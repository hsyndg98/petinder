package tr.edu.ege.petinder.apigateway.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tr.edu.ege.petinder.apigateway.dto.JwtResponse;
import tr.edu.ege.petinder.apigateway.dto.SigninRequest;
import tr.edu.ege.petinder.apigateway.dto.SignupRequest;
import tr.edu.ege.petinder.apigateway.dto.UserDto;
import tr.edu.ege.petinder.apigateway.exception.ServiceException;
import tr.edu.ege.petinder.apigateway.exception.UserError;
import tr.edu.ege.petinder.apigateway.model.User;
import tr.edu.ege.petinder.apigateway.repository.UserRepository;
import tr.edu.ege.petinder.apigateway.security.JwtUtils;
import tr.edu.ege.petinder.apigateway.security.MyUserDetails;
import tr.edu.ege.petinder.apigateway.services.AuthenticationService;
import tr.edu.ege.petinder.apigateway.util.Mapper;

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
        return Mapper.map(user,UserDto.class);
    }
}
