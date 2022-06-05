package tr.edu.ege.petinder.matchingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tr.edu.ege.petinder.matchingservice.dto.mating.MatingDto;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Mating extends Relation {

    //istenilen pet'in id'si
    private Long requestedPetId;

    //isteyenin pet'inin id'si
    private Long requesterPetId;

    public static Mating of(MatingDto matingDto) {
        return Mating.builder()
                .requesterId(matingDto.getRequesterId())
                .requestedPetId(matingDto.getRequestedPetId())
                .petOwnerId(matingDto.getPetOwnerId())
                .requesterPetId(matingDto.getRequesterPetId())
                .build();
    }
}
