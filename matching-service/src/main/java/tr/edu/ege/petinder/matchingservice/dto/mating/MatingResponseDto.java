package tr.edu.ege.petinder.matchingservice.dto.mating;

import lombok.Builder;
import lombok.Data;
import tr.edu.ege.petinder.matchingservice.model.Mating;

import java.util.Date;

@Data
@Builder
public class MatingResponseDto {

    private Long petOwnerId;

    private Long requesterId;

    //istenilen pet'in id'si
    private Long requestedPetId;

    //isteyenin pet'inin id'si
    private Long requesterPetId;

    private boolean isApproved;

    private boolean isReplied = false;

    private boolean isDone = false;

    private Date createdAt;

    private Date updatedAt;

    public static MatingResponseDto of(Mating mating) {
        return MatingResponseDto.builder()
                .petOwnerId(mating.getPetOwnerId())
                .requestedPetId(mating.getRequestedPetId())
                .requesterId(mating.getRequesterId())
                .requesterPetId(mating.getRequesterPetId())
                .isApproved(mating.isApproved())
                .isReplied(mating.isReplied())
                .isDone(mating.isDone())
                .createdAt(mating.getCreatedAt())
                .updatedAt(mating.getUpdatedAt())
                .build();
    }

}
