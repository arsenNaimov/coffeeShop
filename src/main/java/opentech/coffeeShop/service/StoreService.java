package opentech.coffeeShop.service;

import opentech.coffeeShop.model.Store;
import opentech.coffeeShop.repository.StoreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService{

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getAll(){
        return storeRepository.findAll();
    }

    public Store getById(Long id){
        return storeRepository.getOne(id);
    }

    public Store add(Store store){
        return storeRepository.save(store);
    }

    public Store update(Store store){
        Store storeFromDb = storeRepository.getOne(store.getId());
        BeanUtils.copyProperties(store, storeFromDb, "id");
        return storeRepository.save(storeFromDb);
    }

    public void delete(Store store) {
        storeRepository.delete(store);
    }
}
