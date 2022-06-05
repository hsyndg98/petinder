package tr.edu.ege.petinder.apigateway.dto;

import tr.edu.ege.petinder.apigateway.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private String name;

    private String surname;

    private String username;

    private String email;

    public static UserDto of(User user) {
        return UserDto.builder().id(user.getId()).username(user.getUsername()).email(user.getEmail())
                .name(user.getName()).surname(user.getSurname()).build();
    }
}