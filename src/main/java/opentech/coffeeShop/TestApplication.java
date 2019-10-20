package opentech.coffeeShop;

import opentech.coffeeShop.dao.util.HibernateUtil;
import opentech.coffeeShop.model.Product;
import opentech.coffeeShop.model.Store;
import opentech.coffeeShop.service.ProductService;
import opentech.coffeeShop.service.StoreService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestApplication {
    public static void main(String[] args) throws SQLException {

        ProductService productService = new ProductService();
        StoreService storeService = new StoreService();

        Product product = new Product();
        product.setName("Gazirovochka");
        product.setQuantity((long) 3);
        product.setWeightInGrams((long) 0);

        List<Product> products = new ArrayList<Product>();
        products.add(product);
        products.add(product);
        products.add(product);

        Store store = new Store();
        store.setAddress("Tam gde gusi Ga-Ga-Ga");
        store.setName("Romka");
        store.setProducts(products);

        productService.add(product);
        storeService.add(store);

        HibernateUtil.shutdown();
    }
}
