package opentech.coffeeShop.controller;

import opentech.coffeeShop.Entity.ShoppingCard;
import opentech.coffeeShop.service.ShoppingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shopCard")
public class ShoppingCardController {

    private final ShoppingCardService shoppingCardService;

    @Autowired
    public ShoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }

    @GetMapping
    public List<ShoppingCard> getAll() {
        return shoppingCardService.getAll();
    }

    @GetMapping(value = "{id}")
    public ShoppingCard getOne(@PathVariable("id") Long id) {
        return shoppingCardService.getById(id);
    }

    @PostMapping
    public ShoppingCard create(@RequestBody ShoppingCard authorities) {
        return shoppingCardService.add(authorities);
    }

    @PutMapping
    public ShoppingCard update(@RequestBody ShoppingCard authorities) {
        return shoppingCardService.update(authorities);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        shoppingCardService.delete(id);
    }
}
