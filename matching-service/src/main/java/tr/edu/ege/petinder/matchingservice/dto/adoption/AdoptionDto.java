package tr.edu.ege.petinder.matchingservice.dto.adoption;

import lombok.Builder;
import lombok.Data;
import tr.edu.ege.petinder.matchingservice.model.Adoption;

@Data
@Builder
public class AdoptionDto {
    private Long petId;
    private Long petOwnerId;

    private Long requesterId;


    public static AdoptionDto of(Adoption adoption) {
        return AdoptionDto.builder()
                .petId(adoption.getPetId())
                .petOwnerId(adoption.getPetOwnerId())
                .requesterId(adoption.getRequesterId())
                .build();
    }
}
