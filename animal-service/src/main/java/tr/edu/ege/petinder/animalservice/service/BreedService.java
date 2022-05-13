package tr.edu.ege.petinder.animalservice.service;

import tr.edu.ege.petinder.animalservice.dto.breed.BreedDto;
import tr.edu.ege.petinder.animalservice.model.Breed;

import java.util.List;

public interface BreedService {

    BreedDto findById(Long id);

    Breed getById(Long id);

    List<BreedDto> getAll();

    BreedDto create(Breed breed);

    BreedDto update(Breed breed);

    void delete(Long id);
}
