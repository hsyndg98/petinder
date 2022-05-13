package tr.edu.ege.petinder.userservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.edu.ege.petinder.userservice.dto.UserCreationDto;
import tr.edu.ege.petinder.userservice.dto.UserDetailsDto;
import tr.edu.ege.petinder.userservice.model.User;

import java.util.Optional;

public interface UserService {
    Page<UserDetailsDto> findAll(Pageable pageable);

    UserDetailsDto createUser(UserCreationDto user);

    UserDetailsDto getUserById(Long id);

    UserDetailsDto updateUser(Long id,UserCreationDto user);

    void deleteUser(Long id);

    UserDetailsDto findByUsername(String username);


}
