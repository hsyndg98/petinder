package tr.edu.ege.petinder.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.edu.ege.petinder.userservice.model.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SignupDto {
    private String name;
    private String username;
    private String email;
    private String password;

}
