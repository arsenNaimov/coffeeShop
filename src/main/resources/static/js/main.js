function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }

    return -1;
}

// private Long id;
// private String name;
// private Long weightInGrams;
// private Long quantity;

var productApi = Vue.resource('/product{/id}');

Vue.component('product-form', {
    props: ['products', 'productAttr'],
    data: function() {
        return {
            id: '',
            name: '',
            weightInGrams: '',
            quantity: ''
        }
    },
    watch: {
        productAttr: function(newVal, oldVal) {
            this.id = newVal.id;
            this.name = newVal.name;
            this.weightInGrams = newVal.weightInGrams;
            this.quantity = newVal.quantity;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="name" v-model="name" />' +
        '<input type="text" placeholder="weightInGrams" v-model="weightInGrams" />' +
        '<input type="text" placeholder="quantity" v-model="quantity" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
            var product = {
                id: this.id,
                name: this.name,
                weightInGrams: this.weightInGrams,
                quantity: this.quantity};

            if (this.id) {
               productApi.update({}, product).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.products, data.id);
                        this.products.splice(index, 1, data);
                        this.name = '';
                        this.weightInGrams = '';
                        this.quantity = '';
                        this.id = '';
                    })
                )
            } else {
                productApi.save({}, product).then(result =>
                    result.json().then(data => {
                        this.products.push(data);
                        this.name = '';
                        this.weightInGrams = '';
                        this.quantity = '';
                        this.id = '';
                    })
                )
            }
        }
    }
});

Vue.component('product-row', {
    props: ['product', 'editMethod', 'products'],
    template: '<div>' +
        'id: ({{ product.id }}), ' +
        'name: {{ product.name }}, ' +
        'weightInGrams: {{ product.weightInGrams }}, ' +
        'quantity: {{ product.quantity }} ' +
        '<input type="button" value="Edit" @click="edit" />' +
        '<input type="button" value="Delete" @click="del" />' +
        '</div>',
    methods: {
        edit: function() {
            this.editMethod(this.product);
        },
        del: function() {
            productApi.remove({id: this.product.id}).then(result => {
                if (result.ok) {
                    this.products.splice(this.products.indexOf(this.product), 1)
                }
            })
        }
    }
});

Vue.component('products-list', {
    props: ['products'],
    data: function() {
        return {
            product: null
        }
    },
    template:
        '<div>' +
        '<product-form :products="products" :productAttr="product" />' +
        '<product-row v-for="product in products" :key="product.id" :product="product" ' +
        ':editMethod="editMethod" :products="products" />' +
        '</div>',
    created: function() {
        productApi.get().then(result =>
            result.json().then(data =>
                data.forEach(product => this.products.push(product))
            )
        )
    },
    methods: {
        editMethod: function(product) {
            this.product = product;
        }
    }
});


var app = new Vue({
    el: '#app',
    template: '<products-list :products="products" />',
    data: {
        products: []
    }
});