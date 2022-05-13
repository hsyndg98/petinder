package tr.edu.ege.petinder.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.edu.ege.petinder.userservice.model.Pet;
import tr.edu.ege.petinder.userservice.model.Role;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDto {
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String surname;


    @NotNull
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 50)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must contain at least 8 characters, one digit, one uppercase letter, one lowercase letter, one special character and no whitespace")
    private String password;

    @NotNull
    @NotEmpty
    @Size(min = 11, max = 11)
    @Pattern(regexp = "^[0-9]*$", message = "Phone number must be 11 digits")
    private String phoneNumber;

    @NotNull
    @NotEmpty
    private String profilePicture;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 2500)
    private String bio;

    @NotNull
    @Valid //validates the address object
    private AddressDto address;


    private Set<Pet> pets;
}
