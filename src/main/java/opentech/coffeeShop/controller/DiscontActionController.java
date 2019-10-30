package opentech.coffeeShop.controller;

import opentech.coffeeShop.Entity.DiscountAction;
import opentech.coffeeShop.service.DiscountActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("discountAction")
public class DiscontActionController {

    private final DiscountActionService discountActionService;

    @Autowired
    public DiscontActionController(DiscountActionService discountActionService) {
        this.discountActionService = discountActionService;
    }

    @GetMapping
    public List<DiscountAction> getAll() {
        return discountActionService.getAll();
    }

    @GetMapping("{id}")
    public DiscountAction getOne(@PathVariable("id") Long id) {
        return discountActionService.getById(id);
    }

    @PostMapping
    public DiscountAction create(@RequestBody DiscountAction discountAction) {
        return discountActionService.add(discountAction);
    }

    @PutMapping
    public DiscountAction update(@RequestBody DiscountAction discountAction) {
        return discountActionService.update(discountAction);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        discountActionService.delete(id);
    }
}
