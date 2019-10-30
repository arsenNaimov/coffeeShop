package opentech.coffeeShop.service.impl;

import opentech.coffeeShop.Entity.Role;
import opentech.coffeeShop.repository.RoleRepository;
import opentech.coffeeShop.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role getById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("\n" +
                        "Role entity not found by id :  " + id));
    }

    public Role add(Role role) {
        return roleRepository.save(role);
    }

    public Role update(Role role) {
        Role roleFromDb = roleRepository.findById(role.getId())
                .orElseThrow(() -> new EntityNotFoundException("\n" +
                        "Role entity not found by id :  " + role.getId()));
        BeanUtils.copyProperties(role, roleFromDb, "id");
        return roleRepository.save(roleFromDb);
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
