package tr.edu.ege.petinder.matchingservice.service;

import tr.edu.ege.petinder.matchingservice.dto.adoption.AdoptionDto;
import tr.edu.ege.petinder.matchingservice.dto.adoption.AdoptionResponseDto;

import java.util.List;

public interface AdoptionService {

    AdoptionResponseDto create(AdoptionDto adoptionDto);

    void delete(Long id);

    void updateApproved(Long id, boolean isApproved);

    List<AdoptionResponseDto> getAllAdoption(boolean isApproved);

}
