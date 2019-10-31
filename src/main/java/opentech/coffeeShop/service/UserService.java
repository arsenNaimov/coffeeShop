package opentech.coffeeShop.service;

import opentech.coffeeShop.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User findById(Long id);
    User findByUsername(String name);
    User register(User user);
    User registerAdmin(User user);
    User update(User user);
    void delete(Long id);
}
