package opentech.coffeeShop.controller;

import opentech.coffeeShop.Entity.Authorities;
import opentech.coffeeShop.service.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authorities")
public class AuthoritiesController {

    private final AuthoritiesService authoritiesService;

    @Autowired
    public AuthoritiesController(AuthoritiesService authoritiesService) {
        this.authoritiesService = authoritiesService;
    }

    @GetMapping
    public List<Authorities> getAll() {
        return authoritiesService.getAll();
    }

    @GetMapping("{id}")
    public Authorities getOne(@PathVariable("id") Long id) {
        return authoritiesService.getById(id);
    }

    @PostMapping
    public Authorities create(@RequestBody Authorities authorities) {
        return authoritiesService.add(authorities);
    }

    @PutMapping
    public Authorities update(@RequestBody Authorities authorities) {
        return authoritiesService.update(authorities);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        authoritiesService.delete(id);
    }

}
