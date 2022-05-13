package tr.edu.ege.petinder.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.ege.petinder.userservice.dto.UserCreationDto;
import tr.edu.ege.petinder.userservice.dto.UserDetailsDto;
import tr.edu.ege.petinder.userservice.model.User;
import tr.edu.ege.petinder.userservice.service.UserService;
import tr.edu.ege.petinder.userservice.util.Mapper;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserDetailsDto>> findAll(@RequestParam int pageNumber,
                                                        @RequestParam int pageSize,
                                                        @RequestParam String sortBy,
                                                        @RequestParam Sort.Direction direction) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, direction, sortBy);
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<UserDetailsDto> create(@RequestBody @Valid UserCreationDto user) {
        return ResponseEntity.ok(userService.createUser(user));
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetailsDto> update(@PathVariable Long id, @RequestBody @Valid UserCreationDto user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();


    }

}