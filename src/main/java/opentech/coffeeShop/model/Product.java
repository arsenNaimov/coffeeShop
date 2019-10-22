package opentech.coffeeShop.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "WEIGHT_IN_GRAMS")
    private Long weightInGrams;
    @Column(name = "QUANTITY")
    private Long quantity;
    @ManyToMany
    @JoinTable(name = "product_store",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "store_id", referencedColumnName = "id")
    )
    private List<Store> stores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(Long weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                name.equals(product.name) &&
                Objects.equals(weightInGrams, product.weightInGrams) &&
                Objects.equals(quantity, product.quantity) &&
                stores.equals(product.stores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weightInGrams, quantity, stores);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weightInGrams=" + weightInGrams +
                ", quantity=" + quantity +
                '}';
    }
}
