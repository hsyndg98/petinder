package apigateway.services.impl;

import apigateway.dto.JwtResponse;
import apigateway.dto.SigninRequest;
import apigateway.dto.SignupRequest;
import apigateway.dto.UserDto;
import apigateway.exception.ServiceException;
import apigateway.exception.UserError;
import apigateway.model.User;
import apigateway.repository.UserRepository;
import apigateway.security.JwtUtils;
import apigateway.security.MyUserDetails;
import apigateway.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    @Override
    public JwtResponse signIn(SigninRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername());
    }

    @Override
    public UserDto signUp(SignupRequest signUpRequest) {
        if (Boolean.TRUE.equals(userRepository.existsByUsername(signUpRequest.getUsername()))) {
            try {
                throw new ServiceException(UserError.USERNAME_ALREADY_EXISTS);
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        }
        if (Boolean.TRUE.equals(userRepository.existsByEmail(signUpRequest.getEmail()))) {
            try {
                throw new ServiceException(UserError.EMAIL_ALREADY_EXISTS);
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        }
        User user = User.builder()
                .name(signUpRequest.getName())
                .surname(signUpRequest.getSurname())
                .username(signUpRequest.getUsername())
                .email(signUpRequest.getEmail())
                .password(encoder.encode(signUpRequest.getPassword()))
                .build();
        user = userRepository.save(user);
        return UserDto.of(user);
    }
}
