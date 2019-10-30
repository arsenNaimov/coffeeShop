package opentech.coffeeShop.controller;

import opentech.coffeeShop.Entity.Store;
import opentech.coffeeShop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getAll() {
        return storeService.getAll();
    }

    @GetMapping("{id}")
    public Store getOne(@PathVariable Long id) {
        return storeService.getById(id);
    }

    @PostMapping
    public Store create(@RequestBody Store store) {
        return storeService.add(store);
    }

    @PutMapping
    public Store update(@RequestBody Store store) {
        return storeService.update(store);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        storeService.delete(id);
    }
}
