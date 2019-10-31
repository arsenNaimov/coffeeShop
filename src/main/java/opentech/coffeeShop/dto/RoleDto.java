package opentech.coffeeShop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import opentech.coffeeShop.Entity.Role;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDto {
    private Long id;
    private String name;

    public Role toRole() {
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        return role;
    }

    public static RoleDto fromRole(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }
}
