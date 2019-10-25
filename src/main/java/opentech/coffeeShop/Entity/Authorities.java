package opentech.coffeeShop.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Authorities")
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    public Authorities() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorities that = (Authorities) o;
        return id.equals(that.id) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
