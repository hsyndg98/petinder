package tr.edu.ege.petinder.animalservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tr.edu.ege.petinder.animalservice.dto.breed.BreedDto;
import tr.edu.ege.petinder.animalservice.dto.pet.PetCreationDto;
import tr.edu.ege.petinder.animalservice.dto.pet.PetDetailsDto;
import tr.edu.ege.petinder.animalservice.exception.PetError;
import tr.edu.ege.petinder.animalservice.exception.ServiceException;
import tr.edu.ege.petinder.animalservice.model.Breed;
import tr.edu.ege.petinder.animalservice.model.Pet;
import tr.edu.ege.petinder.animalservice.repository.PetRepository;
import tr.edu.ege.petinder.animalservice.service.BreedService;
import tr.edu.ege.petinder.animalservice.service.PetService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final BreedService breedService;

    @Override
    public PetDetailsDto getPet(Long id) {
        final Pet pet = petRepository.findById(id).orElseThrow(() -> new ServiceException(PetError.PET_NOT_FOUND));
        BreedDto breedDto = BreedDto.of(pet.getBreed());
        return PetDetailsDto.convertFrom(pet, breedDto);
    }

    @Override
    public List<PetDetailsDto> getAllPets() {
        return petRepository.findAll().stream()
                .map(pet -> PetDetailsDto.convertFrom(pet, BreedDto.of(pet.getBreed())))
                .collect(Collectors.toList());
    }


    @Override
    public PetDetailsDto create(PetCreationDto petCreationDto) {
        Breed breed = breedService.getById(petCreationDto.getBreedId());
        Pet pet = Pet.convertFrom(petCreationDto, breed);
        BreedDto breedDto = BreedDto.of(breed);
        return PetDetailsDto.convertFrom(petRepository.save(pet), breedDto);
    }

    @Override
    public PetDetailsDto update(PetDetailsDto petDetailsDto) {
        Pet pet = Pet.builder()
                .petName(petDetailsDto.getPetName())
                .age(petDetailsDto.getAge())
                .weight(petDetailsDto.getWeight())
                .height(petDetailsDto.getHeight())
                .gender(petDetailsDto.getGender())
                .vaccines(petDetailsDto.getVaccines())
                .build();
        BreedDto breedDto = BreedDto.of(pet.getBreed());
        return PetDetailsDto.convertFrom(petRepository.save(pet), breedDto);
    }

    @Override
    public void delete(Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new ServiceException(PetError.PET_NOT_FOUND));
        petRepository.delete(pet);
    }
}
