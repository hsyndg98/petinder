package tr.edu.ege.petinder.userservice.payload.request;

import lombok.Data;

@Data
public class SignupRequest {
    String userName;
    String password;
    String email;
}
