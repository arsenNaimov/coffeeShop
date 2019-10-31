package opentech.coffeeShop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import opentech.coffeeShop.Entity.User;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreationUserRequestDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }

    public static CreationUserRequestDto fromUser(User user) {
        CreationUserRequestDto creationUserRequestDto = new CreationUserRequestDto();
        creationUserRequestDto.setId(user.getId());
        creationUserRequestDto.setUsername(user.getUsername());
        creationUserRequestDto.setFirstName(user.getFirstName());
        creationUserRequestDto.setLastName(user.getLastName());
        creationUserRequestDto.setEmail(user.getEmail());
        creationUserRequestDto.setPassword(user.getPassword());
        return creationUserRequestDto;
    }
}
