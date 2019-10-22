package opentech.coffeeShop.repository;

import opentech.coffeeShop.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
