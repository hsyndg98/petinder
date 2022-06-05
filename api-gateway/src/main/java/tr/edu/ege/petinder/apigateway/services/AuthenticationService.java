package tr.edu.ege.petinder.apigateway.services;

import tr.edu.ege.petinder.apigateway.dto.JwtResponse;
import tr.edu.ege.petinder.apigateway.dto.SigninRequest;
import tr.edu.ege.petinder.apigateway.dto.SignupRequest;
import tr.edu.ege.petinder.apigateway.dto.UserDto;

public interface AuthenticationService {

    JwtResponse signIn(SigninRequest signInRequest);

    UserDto signUp(SignupRequest signupRequest);
}
