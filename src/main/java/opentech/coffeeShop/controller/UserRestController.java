package opentech.coffeeShop.controller;

import opentech.coffeeShop.Entity.Status;
import opentech.coffeeShop.Entity.User;
import opentech.coffeeShop.dto.CreationUserRequestDto;
import opentech.coffeeShop.dto.UserDto;
import opentech.coffeeShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users/")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<User> users = userService.getAll();
        if (users == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<UserDto> result = new ArrayList<>();
        users.forEach(user -> result.add(UserDto.fromUser(user)));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<UserDto> create(@RequestBody CreationUserRequestDto creationUserRequestDto) {
        User user = creationUserRequestDto.toUser();
        user.setStatus(Status.ACTIVE);
        user.setCreated(new Date());
        user.setUpdated(new Date());
        UserDto result = UserDto.fromUser(userService.register(user));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        User user = userDto.toUser();
        return new ResponseEntity<>(UserDto.fromUser(userService.update(user)), HttpStatus.OK);
    }
}
