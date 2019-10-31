package opentech.coffeeShop.controller;

import opentech.coffeeShop.Entity.Role;
import opentech.coffeeShop.Entity.Status;
import opentech.coffeeShop.dto.RoleDto;
import opentech.coffeeShop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/admin/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAll() {
        List<Role> roles = roleService.getAll();
        if (roles == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<RoleDto> result = new ArrayList<>();
        roles.forEach(role -> result.add(RoleDto.fromRole(role)));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<RoleDto> getOne(@PathVariable("id") Long id) {
        Role role = roleService.getById(id);
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        RoleDto result = RoleDto.fromRole(role);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDto> create(@RequestBody RoleDto roleDto) {
        Role role = roleDto.toRole();
        role.setStatus(Status.ACTIVE);
        role.setCreated(new Date());
        role.setUpdated(new Date());
        RoleDto result = RoleDto.fromRole(roleService.add(role));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RoleDto> update(@RequestBody RoleDto roleDto) {
        Role role = roleDto.toRole();
        return new ResponseEntity<>(RoleDto.fromRole(roleService.update(role)), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }

}
