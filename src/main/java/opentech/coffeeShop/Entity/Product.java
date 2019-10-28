package opentech.coffeeShop.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "WEIGHT_IN_GRAMS")
    private Long weightInGrams;

    @Column(name = "QUANTITY")
    private Long quantity;
}
