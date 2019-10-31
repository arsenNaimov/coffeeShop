package opentech.coffeeShop.controller;

import opentech.coffeeShop.Entity.Product;
import opentech.coffeeShop.Entity.Status;
import opentech.coffeeShop.dto.ProductDto;
import opentech.coffeeShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/admin/products/")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        List<Product> products = productService.getAll();
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<ProductDto> result = new ArrayList<>();
        products.forEach(product -> result.add(ProductDto.fromProduct(product)));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ProductDto> getOne(@PathVariable("id") Long id) {
        Product product = productService.getById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ProductDto result = ProductDto.fromProduct(product);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        Product product = productDto.toProduct();
        product.setStatus(Status.ACTIVE);
        product.setCreated(new Date());
        product.setUpdated(new Date());
        ProductDto result = ProductDto.fromProduct(productService.add(product));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
        Product product = productDto.toProduct();
        return new ResponseEntity<>(ProductDto.fromProduct(productService.update(product)), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
