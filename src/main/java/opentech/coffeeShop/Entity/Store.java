package opentech.coffeeShop.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "STORE")
public class Store extends BaseEntity{

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToMany(mappedBy = "stores", fetch = FetchType.EAGER)
    private List<Product> products;
}
