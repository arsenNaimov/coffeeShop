package opentech.coffeeShop.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long weightInGrams;
    private Long quantity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(Long weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                name.equals(product.name) &&
                weightInGrams.equals(product.weightInGrams) &&
                quantity.equals(product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weightInGrams, quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weightInGrams=" + weightInGrams +
                ", quantity=" + quantity +
                '}';
    }
}
