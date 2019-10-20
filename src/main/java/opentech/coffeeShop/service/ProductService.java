package opentech.coffeeShop.service;

import opentech.coffeeShop.dao.ProductDAO;
import opentech.coffeeShop.dao.util.SessionUtil;
import opentech.coffeeShop.model.Product;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService extends SessionUtil implements ProductDAO {

    @Override
    public void add(Product product) throws SQLException {
        openTransactionSession();
        getSession().save(product);
        closeTransactionSession();
    }

    @Override
    public List<Product> getAll() throws SQLException {
        openTransactionSession();
        List<Product> products = getSession().createNativeQuery("SELECT * FROM PRODUCT").addEntity(Product.class).list();
        closeTransactionSession();
        return products;
    }

    @Override
    public Product getById(Long id) throws SQLException {
        openTransactionSession();
        Product product = (Product) getSession().createNativeQuery("SELECT * FROM PRODUCT WHERE ID = :id")
                .addEntity(Product.class).setParameter("id", id).getSingleResult();
        closeTransactionSession();
        return product;
    }

    @Override
    public void update(Product product) throws SQLException {
        openTransactionSession();
        getSession().update(product);
        closeTransactionSession();
    }

    @Override
    public void delete(Product product) throws SQLException {
        openTransactionSession();
        getSession().remove(product);
        closeTransactionSession();
    }
}
