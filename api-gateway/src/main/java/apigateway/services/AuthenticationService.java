package apigateway.services;

import apigateway.dto.JwtResponse;
import apigateway.dto.SigninRequest;
import apigateway.dto.SignupRequest;
import apigateway.dto.UserDto;

public interface AuthenticationService {

    JwtResponse signIn(SigninRequest signInRequest);

    UserDto signUp(SignupRequest signupRequest);
}
