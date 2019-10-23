package opentech.coffeeShop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product{

    @Id
    private Long id;
    private String name;
    private Long weightInGrams;
    private Long quantity;
    @ManyToMany
    @JoinTable(name = "product_store",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "store_id", referencedColumnName = "id")
    )
    private List<Store> stores;

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

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
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
