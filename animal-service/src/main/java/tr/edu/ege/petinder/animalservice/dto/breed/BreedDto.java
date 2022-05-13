package tr.edu.ege.petinder.animalservice.dto.breed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tr.edu.ege.petinder.animalservice.model.Breed;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BreedDto {

    private Long id;

    private String name;

    private String animal;

    public static BreedDto of(Breed breed){
        return BreedDto.builder()
                .name(breed.getName())
                .animal(breed.getAnimal().toString())
                .build();
    }
}
