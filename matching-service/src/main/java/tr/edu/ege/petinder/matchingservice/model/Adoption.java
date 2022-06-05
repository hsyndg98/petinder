package tr.edu.ege.petinder.matchingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tr.edu.ege.petinder.matchingservice.dto.adoption.AdoptionDto;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder

public class Adoption extends Relation {

    private Long petId;

    public static Adoption of(AdoptionDto adoptionDto){
        return Adoption.builder()
                .petId(adoptionDto.getPetId())
                .petOwnerId(adoptionDto.getPetOwnerId())
                .requesterId(adoptionDto.getRequesterId())
                .build();
    }

}
