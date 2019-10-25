package opentech.coffeeShop.service;

import opentech.coffeeShop.Entity.Authorities;
import opentech.coffeeShop.repository.AuthoritiesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthoritiesService {
    private final AuthoritiesRepository authoritiesRepository;

    @Autowired
    public AuthoritiesService(AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
    }

    public List<Authorities> getAll() {
        return authoritiesRepository.findAll();
    }

    public Authorities getById(Long id) {
        return authoritiesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("\n" +
                        "Authorities entity not found by id :  " + id));
    }

    public Authorities add(Authorities authorities) {
        return authoritiesRepository.save(authorities);
    }

    public Authorities update(Authorities authorities) {
        Authorities authoritiesFromDb = authoritiesRepository.findById(authorities.getId())
                .orElseThrow(() -> new EntityNotFoundException("\n" +
                        "Authorities entity not found by id :  " + authorities.getId()));
        BeanUtils.copyProperties(authorities, authoritiesFromDb, "id");
        return authoritiesRepository.save(authoritiesFromDb);
    }

    public void delete(Long id) {
        authoritiesRepository.deleteById(id);
    }
}
