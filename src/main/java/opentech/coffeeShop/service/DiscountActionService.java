package opentech.coffeeShop.service;

import opentech.coffeeShop.Entity.DiscountAction;
import java.util.List;

public interface DiscountActionService {
    List<DiscountAction> getAll();

    DiscountAction getById(Long id);

    DiscountAction add(DiscountAction discountAction);

    DiscountAction update(DiscountAction discountAction);

    void delete(Long id);
}
