package opentech.coffeeShop.controller;

public interface BaseController {
    //create
    Object create(Object object);
    //read
    Object getAll();
    Object getOne(Long id);
    //update
    Object update(Object object);
    //delete
    void delete(Object object);
}
