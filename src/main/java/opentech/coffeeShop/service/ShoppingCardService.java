package opentech.coffeeShop.service;

import opentech.coffeeShop.Entity.ShoppingCard;

import java.util.List;

public interface ShoppingCardService {
    List<ShoppingCard> getAll();

    ShoppingCard getById(Long id);

    ShoppingCard add(ShoppingCard shoppingCard);

    ShoppingCard update(ShoppingCard shoppingCard);

    void delete(Long id);
}
