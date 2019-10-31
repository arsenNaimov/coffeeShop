package opentech.coffeeShop.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import opentech.coffeeShop.Entity.Product;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

    private Long id;
    private String name;
    private Long weightInGrams;
    private Long quantity;


    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setWeightInGrams(weightInGrams);
        product.setQuantity(quantity);
        return product;
    }

    public static ProductDto fromProduct(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setQuantity(product.getQuantity());
        productDto.setWeightInGrams(product.getWeightInGrams());
        return productDto;
    }
}
