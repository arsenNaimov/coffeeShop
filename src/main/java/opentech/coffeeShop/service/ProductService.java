package opentech.coffeeShop.service;

import opentech.coffeeShop.Entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(Long id);

    Product add(Product product);

    Product update(Product product);

    void delete(Long id);
}
