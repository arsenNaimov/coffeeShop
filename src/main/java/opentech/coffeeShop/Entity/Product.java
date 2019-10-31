package opentech.coffeeShop.Entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "PRODUCT")
public class Product extends BaseEntity{

    @Column(name = "NAME")
    private String name;

    @Column(name = "WEIGHT_IN_GRAMS")
    private Long weightInGrams;

    @Column(name = "QUANTITY")
    private Long quantity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_stores",
                joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "store_id", referencedColumnName = "id")})
    private List<Store> stores;
}
