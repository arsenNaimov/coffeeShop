package opentech.coffeeShop.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "STORE")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME")
    String name;

    @Column(name = "ADDRESS")
    String address;
}
