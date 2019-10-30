package opentech.coffeeShop.service;

import opentech.coffeeShop.Entity.Authorities;
import java.util.List;

public interface AuthoritiesService {
    List<Authorities> getAll();

    Authorities getById(Long id);

    Authorities add(Authorities authorities);

    Authorities update(Authorities authorities);

    void delete(Long id);
}
