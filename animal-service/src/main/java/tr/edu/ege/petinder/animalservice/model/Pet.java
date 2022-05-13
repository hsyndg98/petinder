package tr.edu.ege.petinder.animalservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tr.edu.ege.petinder.animalservice.dto.pet.PetCreationDto;
import tr.edu.ege.petinder.animalservice.dto.pet.PetDetailsDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Pet extends BaseEntity {

    private String petName;

    private String colour;

    private int age;

    private int weight;

    private int height;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Breed breed;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<Vaccine> vaccines;

    public static Pet convertFrom(PetDetailsDto petDetailsDto) {
        return Pet.builder()
                .id(petDetailsDto.getId())
                .petName(petDetailsDto.getPetName())
                .age(petDetailsDto.getAge())
                .colour(petDetailsDto.getColour())
                .gender(petDetailsDto.getGender())
                .height(petDetailsDto.getHeight())
                .weight(petDetailsDto.getWeight())
                .vaccines(petDetailsDto.getVaccines())
                .build();
    }

    public static Pet convertFrom(PetCreationDto petCreationDto, Breed breed) {
        return Pet.builder()
                .petName(petCreationDto.getPetName())
                .age(petCreationDto.getAge())
                .colour(petCreationDto.getColour())
                .gender(petCreationDto.getGender())
                .height(petCreationDto.getHeight())
                .weight(petCreationDto.getWeight())
                .vaccines(petCreationDto.getVaccines())
                .breed(breed)
                .build();
    }
}
