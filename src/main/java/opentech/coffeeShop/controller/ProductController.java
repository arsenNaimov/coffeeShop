package opentech.coffeeShop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController implements ControllerCrud {

    @GetMapping
    public Object create(Object object) {
        return "it's worked";
    }

    public Object getAll() {
        return null;
    }

    public Object getOne(Long id) {
        return null;
    }

    public Object update(Object object) {
        return null;
    }

    public void delete(Object object) {

    }
}
