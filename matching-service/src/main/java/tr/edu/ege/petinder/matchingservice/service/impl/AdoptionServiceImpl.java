package tr.edu.ege.petinder.matchingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.edu.ege.petinder.matchingservice.dto.adoption.AdoptionDto;
import tr.edu.ege.petinder.matchingservice.dto.adoption.AdoptionResponseDto;
import tr.edu.ege.petinder.matchingservice.model.Adoption;
import tr.edu.ege.petinder.matchingservice.repository.AdoptionRepository;
import tr.edu.ege.petinder.matchingservice.service.AdoptionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {

    private final AdoptionRepository adoptionRepository;

    @Override
    public AdoptionResponseDto create(AdoptionDto adoptionDto) {
        Adoption adoption = Adoption.of(adoptionDto);
        return AdoptionResponseDto.of(adoptionRepository.save(adoption));
    }

    @Override
    public void delete(Long id) {
        adoptionRepository.deleteById(id);
    }

    @Override
    public void updateApproved(Long id, boolean isApproved) {
        Adoption adoption = adoptionRepository.getById(id);
        adoption.setApproved(isApproved);
    }

    @Override
    public List<AdoptionResponseDto> getAllAdoption(boolean isApproved) {
        if (isApproved) {
            return adoptionRepository.findAllByIsApprovedIsTrue().stream()
                    .map(AdoptionResponseDto::of)
                    .collect(Collectors.toList());
        }
        return adoptionRepository.findAllByIsApprovedIsFalse().stream()
                .map(AdoptionResponseDto::of)
                .collect(Collectors.toList());
    }


}
