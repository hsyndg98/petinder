package tr.edu.ege.petinder.animalservice.dto.pet;

import lombok.*;
import tr.edu.ege.petinder.animalservice.model.Gender;
import tr.edu.ege.petinder.animalservice.model.Vaccine;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetCreationDto {

    @Size(min = 0, max = 100)
    private int age;

    private String petName;

    private String colour;

    private int weight;

    private int height;

    @NotNull
    private Long breedId;

    @NotNull
    @NotEmpty
    private Gender gender;

    private Set<Vaccine> vaccines;

}
