package opentech.coffeeShop.controller;

import opentech.coffeeShop.Entity.Status;
import opentech.coffeeShop.Entity.User;
import opentech.coffeeShop.dto.AdminUserDto;
import opentech.coffeeShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/users/")
public class AdminUserRestController {

    private final UserService userService;

    @Autowired
    public AdminUserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<AdminUserDto>> getAll() {
        List<User> users = userService.getAll();
        if(users == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<AdminUserDto> result = new ArrayList<>();
        users.forEach(user -> result.add(AdminUserDto.fromUser(user)));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        AdminUserDto result = AdminUserDto.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AdminUserDto> create(@RequestBody AdminUserDto adminUserDto) {
        User user = adminUserDto.toUser();
        user.setStatus(Status.ACTIVE);
        user.setCreated(new Date());
        user.setUpdated(new Date());
        AdminUserDto result = AdminUserDto.fromUser(userService.registerAdmin(user));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AdminUserDto> update(@RequestBody AdminUserDto adminUserDto) {
        User user = adminUserDto.toUser();
        return new ResponseEntity<>(AdminUserDto.fromUser(userService.update(user)), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}