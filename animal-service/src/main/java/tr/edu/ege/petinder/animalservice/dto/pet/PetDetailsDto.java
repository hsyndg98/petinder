package tr.edu.ege.petinder.animalservice.dto.pet;

import lombok.*;
import tr.edu.ege.petinder.animalservice.dto.breed.BreedDto;
import tr.edu.ege.petinder.animalservice.model.Gender;
import tr.edu.ege.petinder.animalservice.model.Pet;
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
public class PetDetailsDto {

    @NotNull
    private Long id;

    private BreedDto breed;

    @Size(min = 0, max = 100)
    private int age;

    private String petName;

    private String colour;

    private int weight;

    private int height;

    @NotNull
    @NotEmpty
    private Gender gender;

    private Set<Vaccine> vaccines;



    public static PetDetailsDto convertFrom(Pet pet,BreedDto breedDto) {
        return PetDetailsDto.builder()
                .petName(pet.getPetName())
                .age(pet.getAge())
                .colour(pet.getColour())
                .gender(pet.getGender())
                .height(pet.getHeight())
                .weight(pet.getWeight())
                .vaccines(pet.getVaccines())
                .breed(breedDto)
                .build();
    }

}
