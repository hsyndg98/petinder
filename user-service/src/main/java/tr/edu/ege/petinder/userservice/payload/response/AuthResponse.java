package tr.edu.ege.petinder.userservice.payload.response;


import lombok.Data;

@Data
public class AuthResponse {

    Long userId;
    String accessToken;
}