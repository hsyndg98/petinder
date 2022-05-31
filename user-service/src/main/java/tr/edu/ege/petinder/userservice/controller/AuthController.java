package tr.edu.ege.petinder.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tr.edu.ege.petinder.userservice.dto.UserCreationDto;
import tr.edu.ege.petinder.userservice.dto.UserDetailsDto;
import tr.edu.ege.petinder.userservice.model.User;
import tr.edu.ege.petinder.userservice.payload.request.LoginRequest;
import tr.edu.ege.petinder.userservice.payload.request.SignupRequest;
import tr.edu.ege.petinder.userservice.payload.response.AuthResponse;
import tr.edu.ege.petinder.userservice.payload.response.JwtResponse;
import tr.edu.ege.petinder.userservice.repository.RoleRepository;
import tr.edu.ege.petinder.userservice.repository.UserRepository;
import tr.edu.ege.petinder.userservice.security.JwtTokenProvider;
import tr.edu.ege.petinder.userservice.security.MyUserDetails;
import tr.edu.ege.petinder.userservice.service.impl.UserServiceImpl;
import tr.edu.ege.petinder.userservice.util.Mapper;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
        UserDetailsDto user = userServiceImpl.findByUsername(loginRequest.getUsername());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAccessToken("Bearer " + jwtToken);
        //  authResponse.setRefreshToken(refreshTokenService.createRefreshToken(user));
        authResponse.setUserId(user.getId());
        return authResponse;
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserCreationDto signUpRequest) {
        userServiceImpl.createUser(signUpRequest);
        return  ResponseEntity.ok("User registered succesfully");
    }






//    @PostMapping("/register")
//    public ResponseEntity<AuthResponse> register(@RequestBody User user) {
//        AuthResponse authResponse = new AuthResponse();
////        if(userServiceImpl.findByUsername(registerRequest.getUserName())) {
////            authResponse.setMessage("Username already in use.");
////            return new ResponseEntity<>(authResponse, HttpStatus.BAD_REQUEST);
////        }
//        user.setPassword(encoder.encode(user.getPassword()));
//
//        userServiceImpl.saveOneUser(user);
//
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
//        Authentication auth = authenticationManager.authenticate(authToken);
//        SecurityContextHolder.getContext().setAuthentication(auth);
//        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
//
//        authResponse.setMessage("User successfully registered.");
//        authResponse.setAccessToken("Bearer " + jwtToken);
//        //authResponse.setRefreshToken(refreshTokenService.createRefreshToken(user));
//
//        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
//    }

}
