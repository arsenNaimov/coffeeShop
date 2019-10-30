package opentech.coffeeShop.service;

import opentech.coffeeShop.Entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();

    Role getById(Long id);

    Role add(Role role);

    Role update(Role role);

    void delete(Long id);
}
