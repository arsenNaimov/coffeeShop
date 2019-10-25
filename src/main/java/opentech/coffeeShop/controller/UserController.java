package opentech.coffeeShop.controller;

import opentech.coffeeShop.Entity.User;
import opentech.coffeeShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.add(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
