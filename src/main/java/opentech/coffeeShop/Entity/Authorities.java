package opentech.coffeeShop.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Authorities")
public class Authorities extends BaseEntity{

    @Column(name = "DESCRIPTION")
    private String description;
}
