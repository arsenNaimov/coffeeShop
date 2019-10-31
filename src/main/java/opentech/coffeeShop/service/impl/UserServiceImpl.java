package opentech.coffeeShop.service.impl;

import lombok.extern.slf4j.Slf4j;
import opentech.coffeeShop.Entity.Role;
import opentech.coffeeShop.Entity.Status;
import opentech.coffeeShop.Entity.User;
import opentech.coffeeShop.repository.RoleRepository;
import opentech.coffeeShop.repository.UserRepository;
import opentech.coffeeShop.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        if(userRepository.findByUsername(user.getUsername()) != null){
            new EntityExistsException("\n" +
                    "user entity already exists");
            return null;
        }
        return  userRepository.save(user);
    }

    @Override
    public User registerAdmin(User user) {
        Role roleUser = roleRepository.findByName("ROLE_ADMIN");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        if(userRepository.findByUsername(user.getUsername()) != null){
            new EntityExistsException("\n" +
                    "user entity already exists");
            return null;
        }
        return  userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);
        if (result == null){
            new EntityNotFoundException("\n" +
                    "User entity not found by id :  " + id);
            return null;
        }
        return result;
    }

    @Override
    public User findByUsername(String name) {
        User result =  userRepository.findByUsername(name);
        System.out.println(result);
        return result;
    }


    public User update(User user) {
        User userFromDb = userRepository.findById(user.getId())
                .orElseThrow(() -> new EntityNotFoundException("\n" +
                        "User entity not found by id :  " + user.getId()));
        BeanUtils.copyProperties(user, userFromDb, "id");
        return userRepository.save(userFromDb);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
