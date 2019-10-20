package opentech.coffeeShop.dao;

import opentech.coffeeShop.model.Store;

import java.sql.SQLException;
import java.util.List;

public interface StoreDAO {
    //add
    void add(Store store) throws SQLException;

    //read
    List<Store> getAll() throws SQLException;
    Store getById(Long id) throws SQLException;

    //update
    void update(Store store) throws SQLException;

    //delete
    void delete(Store store) throws SQLException;
}
