package opentech.coffeeShop.dao;

import opentech.coffeeShop.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    //add
    void add(Product product) throws SQLException;

    //read
    List<Product> getAll() throws SQLException;
    Product getById(Long id) throws SQLException;

    //update
    void update(Product product) throws SQLException;

    //delete
    void delete(Product product) throws SQLException;
}
