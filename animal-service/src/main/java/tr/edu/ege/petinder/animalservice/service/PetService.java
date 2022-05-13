package tr.edu.ege.petinder.animalservice.service;

import tr.edu.ege.petinder.animalservice.dto.pet.PetCreationDto;
import tr.edu.ege.petinder.animalservice.dto.pet.PetDetailsDto;

import java.util.List;

public interface PetService {
    PetDetailsDto getPet(Long id);

    List<PetDetailsDto> getAllPets();

    PetDetailsDto create(PetCreationDto petCreationDto);

    PetDetailsDto update(PetDetailsDto petDetailsDto);

    void delete(Long id);
}
