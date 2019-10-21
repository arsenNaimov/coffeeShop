package opentech.coffeeShop.service;

import opentech.coffeeShop.entity.Store;
import opentech.coffeeShop.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    StoreRepository shopRepository;
    public void save(Store store){
        shopRepository.save(store);
    }
}
