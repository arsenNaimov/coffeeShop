package opentech.coffeeShop.service;

import opentech.coffeeShop.Entity.Store;
import opentech.coffeeShop.repository.StoreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    public Store getById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("\n" +
                        "Store entity not found by id :  " + id));
    }

    public Store add(Store store) {
        return storeRepository.save(store);
    }

    public Store update(Store store) {
        Store storeFromDb = storeRepository.findById(store.getId())
                .orElseThrow(() -> new EntityNotFoundException("\n" +
                        "Store entity not found by id :  " + store.getId()));
        BeanUtils.copyProperties(store, storeFromDb, "id");
        return storeRepository.save(storeFromDb);
    }

    public void delete(Long id) {
        storeRepository.deleteById(id);
    }
}
