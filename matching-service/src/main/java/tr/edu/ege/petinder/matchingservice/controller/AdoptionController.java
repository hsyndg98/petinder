package tr.edu.ege.petinder.matchingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.edu.ege.petinder.matchingservice.dto.adoption.AdoptionDto;
import tr.edu.ege.petinder.matchingservice.dto.adoption.AdoptionResponseDto;
import tr.edu.ege.petinder.matchingservice.service.AdoptionService;

import java.util.List;

@RestController
@RequestMapping("api/v1/adoption")
@RequiredArgsConstructor
public class AdoptionController {
    private final AdoptionService adoptionService;

    @PostMapping
    public AdoptionResponseDto create(@RequestBody AdoptionDto adoptionDto){
        return adoptionService.create(adoptionDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        adoptionService.delete(id);
    }

    @PatchMapping
    public void updateApproved(@RequestParam Long id,
                               @RequestParam boolean isApproved){
        adoptionService.updateApproved(id, isApproved);
    }

    @GetMapping
    public List<AdoptionResponseDto> getAllAdoption(@RequestParam boolean isApproved){
        return adoptionService.getAllAdoption(isApproved);
    }

}
