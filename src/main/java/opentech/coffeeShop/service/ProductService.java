package opentech.coffeeShop.service;

import opentech.coffeeShop.Entity.Product;
import opentech.coffeeShop.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("\n" +
                        "Product entity not found by id :  " + id));
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product) {
        Product productFromDb = productRepository.findById(product.getId())
                .orElseThrow(() -> new EntityNotFoundException("\n" +
                        "Product entity not found by id :  " + product.getId()));
        BeanUtils.copyProperties(product, productFromDb, "id");
        return productRepository.save(productFromDb);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
