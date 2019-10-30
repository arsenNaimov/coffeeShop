package opentech.coffeeShop.controller;

import opentech.coffeeShop.Entity.Role;
import opentech.coffeeShop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("{id}")
    public Role getOne(@PathVariable("id") Long id) {
        return roleService.getById(id);
    }

    @PostMapping
    public Role create(@RequestBody Role role) {
        return roleService.add(role);
    }

    @PutMapping
    public Role update(@RequestBody Role role) {
        return roleService.update(role);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }
}
