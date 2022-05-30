package tr.edu.ege.petinder.userservice.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tr.edu.ege.petinder.userservice.dto.UserCreationDto;
import tr.edu.ege.petinder.userservice.dto.UserDetailsDto;
import tr.edu.ege.petinder.userservice.exceptions.AddressDtoError;
import tr.edu.ege.petinder.userservice.exceptions.ServiceException;
import tr.edu.ege.petinder.userservice.exceptions.UserError;
import tr.edu.ege.petinder.userservice.model.RoleType;
import tr.edu.ege.petinder.userservice.model.User;
import tr.edu.ege.petinder.userservice.repository.RoleRepository;
import tr.edu.ege.petinder.userservice.repository.UserRepository;
import tr.edu.ege.petinder.userservice.service.UserService;
import tr.edu.ege.petinder.userservice.util.Mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public Page<UserDetailsDto> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return new PageImpl<>(users.getContent().stream().map(user ->
                        Mapper.map(user, UserDetailsDto.class)
               /* UserDetailsDto.builder()
                        .bio(user.getBio())
                        .email(user.getEmail())
                        .id(user.getId())
                        .name(user.getName())
                        .phoneNumber(user.getPhoneNumber())
                        .username(user.getUsername())
                        .address(AddressDto.builder().
                                city(user.getAddress().getCity())
                                .country(user.getAddress().getCountry())
                                .state(user.getAddress().getState())
                                .street(user.getAddress().getStreet())
                                .zipCode(user.getAddress().getZipCode())
                                .build())
                        .build()*/
        ).collect(Collectors.toList()), users.getPageable(), users.getTotalElements());
    }
    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public UserDetailsDto createUser(UserCreationDto user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new ServiceException(UserError.USERNAME_ALREADY_REGISTERED);
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ServiceException(UserError.USER_EMAIL_ALREADY_REGISTERED);
        }

        Set<String> strRoles= user.getRole();
        Set<String> roles = new HashSet<>();

        if (strRoles == null) {
            String userRole =  roleRepository.findByName(RoleType.ROLE_USER).toString();

            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        String adminRole =  roleRepository.findByName(RoleType.ROLE_ADMIN).toString();

                        roles.add(adminRole);

                        break;

                    default:
                        String userRole =  roleRepository.findByName(RoleType.ROLE_USER).toString();

                        roles.add(userRole);
                }
            });
        }

     user.setRole(roles);


        User newUser = userRepository.save(Mapper.map(user, User.class));

        return Mapper.map(newUser, UserDetailsDto.class);

    }

    @Override
    public UserDetailsDto getUserById(Long id) {
        User user =
                userRepository.findById(id)
                        .orElseThrow(() -> new ServiceException(UserError.USER_NOT_FOUND));
        return Mapper.map(user, UserDetailsDto.class);
    }

    protected User findUser(Long id) {
        User user =
                userRepository.findById(id)
                        .orElseThrow(() -> new ServiceException(UserError.USER_NOT_FOUND));
        return user;
    }

    @Override
    public UserDetailsDto updateUser(Long id, UserCreationDto user) {
        User userInDb = findUser(id);
        if (!userInDb.getUsername().equals(user.getUsername())
                && userRepository.existsByUsername(user.getUsername())) {
            throw new ServiceException(UserError.USERNAME_ALREADY_REGISTERED);
        }
        if (!userInDb.getEmail().equals(user.getEmail())
                && userRepository.existsByEmail(user.getEmail())) {
            throw new ServiceException(UserError.USER_EMAIL_ALREADY_REGISTERED);
        }
        if (!userInDb.getPhoneNumber().equals(user.getPhoneNumber())
                && userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            throw new ServiceException(UserError.PHONE_NUMBER_ALREADY_REGISTERED);
        }
        User userToUpdate = Mapper.map(user, User.class);
        userToUpdate.setId(id);
        User uptadedUser = userRepository.save(userToUpdate);
        return Mapper.map(uptadedUser, UserDetailsDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        User userInDb = findUser(id);


        Objects.requireNonNull(id, "id must not be null");
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        userRepository.delete(user);
    }

    @Override
    public UserDetailsDto findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ServiceException(UserError.USER_NOT_FOUND);
        }

        return Mapper.map(userRepository.findByUsername(username), UserDetailsDto.class);
    }

     boolean isFullOfNulls(Object o) {
        boolean allNull = true;
        try {
            for (Field f : o.getClass().getDeclaredFields()){
                allNull &= f.get(o) == null;
            }
        } catch (IllegalAccessException ignored) {
            return true;
        }

        return allNull;
    }


}
