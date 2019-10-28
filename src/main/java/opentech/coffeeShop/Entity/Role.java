package opentech.coffeeShop.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AUTHORITIES_ID")
    private Long authoritiesID;
}
