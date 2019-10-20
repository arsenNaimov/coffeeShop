package opentech.coffeeShop.service;

import opentech.coffeeShop.dao.StoreDAO;
import opentech.coffeeShop.dao.util.SessionUtil;
import opentech.coffeeShop.model.Store;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StoreService extends SessionUtil implements StoreDAO {


    @Override
    public void add(Store store) throws SQLException {
        openTransactionSession();
        getSession().save(store);
        closeTransactionSession();
    }

    @Override
    public List<Store> getAll() throws SQLException {
        openTransactionSession();
        List<Store> stores = getSession().createNativeQuery
                ("SELECT * FROM STORE").addEntity(Store.class).list();
        closeTransactionSession();
        return stores;
    }

    @Override
    public Store getById(Long id) throws SQLException {
        openTransactionSession();
        Store store = (Store) openSession().createNativeQuery("SELECT * FROM STORE WHERE ID = :id")
                .addEntity(Store.class).setParameter("id", id).getSingleResult();
        closeTransactionSession();
        return store;
    }

    @Override
    public void update(Store store) throws SQLException {
        openTransactionSession();
        getSession().update(store);
        closeTransactionSession();
    }

    @Override
    public void delete(Store store) throws SQLException {
        openTransactionSession();
        getSession().remove(store);
        closeTransactionSession();
    }
}
