package opentech.coffeeShop.service;

import opentech.coffeeShop.Entity.User;
import opentech.coffeeShop.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("\n" +
                        "User entity not found by id :  " + id));
    }

    public User add(User user) {
        return userRepository.save(user);
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
