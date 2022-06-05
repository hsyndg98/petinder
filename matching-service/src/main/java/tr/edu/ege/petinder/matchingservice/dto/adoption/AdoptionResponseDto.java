package tr.edu.ege.petinder.matchingservice.dto.adoption;

import lombok.Builder;
import lombok.Data;
import tr.edu.ege.petinder.matchingservice.model.Adoption;

import java.util.Date;

@Data
@Builder
public class AdoptionResponseDto {

    private Long petId;

    private Long petOwnerId;

    private Long requesterId;

    private boolean isApproved;

    private boolean isReplied = false;

    private boolean isDone = false;


    private Date createdAt;

    private Date updatedAt;

    public static AdoptionResponseDto of(Adoption adoption) {
        return AdoptionResponseDto.builder()
                .petId(adoption.getPetId())
                .petOwnerId(adoption.getPetOwnerId())
                .requesterId(adoption.getRequesterId())
                .isApproved(adoption.isApproved())
                .isDone(adoption.isDone())
                .isReplied(adoption.isReplied())
                .createdAt(adoption.getCreatedAt())
                .updatedAt(adoption.getUpdatedAt())
                .build();
    }
}
