package opentech.coffeeShop.Entity;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
