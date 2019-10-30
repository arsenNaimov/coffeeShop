package opentech.coffeeShop.service;

import opentech.coffeeShop.Entity.Store;
import java.util.List;

public interface StoreService {
    List<Store> getAll();

    Store getById(Long id);

    Store add(Store store);

    Store update(Store store);

    void delete(Long id);
}
