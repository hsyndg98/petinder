package tr.edu.ege.petinder.matchingservice.dto.mating;

import lombok.Builder;
import lombok.Data;
import tr.edu.ege.petinder.matchingservice.model.Mating;

@Data
@Builder
public class MatingDto {

    private Long petOwnerId;

    private Long requesterId;

    //istenilen pet'in id'si
    private Long requestedPetId;

    //isteyenin pet'inin id'si
    private Long requesterPetId;

    public static MatingDto of(Mating mating) {
        return MatingDto.builder()
                .petOwnerId(mating.getPetOwnerId())
                .requestedPetId(mating.getRequestedPetId())
                .requesterId(mating.getRequesterId())
                .requesterPetId(mating.getRequesterPetId())
                .build();
    }
}
