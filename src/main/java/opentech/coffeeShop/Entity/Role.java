package opentech.coffeeShop.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    private Long authoritiesID;

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

    public Long getAuthoritiesID() {
        return authoritiesID;
    }

    public void setAuthoritiesID(Long authoritiesID) {
        this.authoritiesID = authoritiesID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id.equals(role.id) &&
                name.equals(role.name) &&
                authoritiesID.equals(role.authoritiesID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, authoritiesID);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authoritiesID=" + authoritiesID +
                '}';
    }
}
