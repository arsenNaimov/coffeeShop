package opentech.coffeeShop.controller;

import opentech.coffeeShop.Entity.Status;
import opentech.coffeeShop.Entity.Store;
import opentech.coffeeShop.dto.StoreDto;
import opentech.coffeeShop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/admin/store/")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public ResponseEntity<List<StoreDto>> getAll() {
        List<Store> stores = storeService.getAll();
        if (stores == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<StoreDto> result = new ArrayList<>();
        stores.forEach(store -> result.add(StoreDto.fromStore(store)));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<StoreDto> getOne(@PathVariable("id") Long id) {
        Store store = storeService.getById(id);
        if (store == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        StoreDto result = StoreDto.fromStore(store);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StoreDto> create(@RequestBody StoreDto storeDto) {
        Store store = storeDto.toStore();
        store.setStatus(Status.ACTIVE);
        store.setCreated(new Date());
        store.setUpdated(new Date());
        StoreDto result = StoreDto.fromStore(storeService.add(store));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StoreDto> update(@RequestBody StoreDto storeDto) {
        Store store = storeDto.toStore();
        return new ResponseEntity<>(StoreDto.fromStore(storeService.update(store)), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        storeService.delete(id);
    }

}
