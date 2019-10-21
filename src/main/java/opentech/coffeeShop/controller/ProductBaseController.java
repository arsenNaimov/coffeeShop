package opentech.coffeeShop.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductBaseController implements BaseController {


    @Override
    public Object create(Object object) {
        return null;
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
