package tr.edu.ege.petinder.animalservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.edu.ege.petinder.animalservice.dto.breed.BreedDto;
import tr.edu.ege.petinder.animalservice.exception.BreedError;
import tr.edu.ege.petinder.animalservice.exception.ServiceException;
import tr.edu.ege.petinder.animalservice.model.Breed;
import tr.edu.ege.petinder.animalservice.repository.BreedRepository;
import tr.edu.ege.petinder.animalservice.service.BreedService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BreedServiceImpl implements BreedService {

    private final BreedRepository breedRepository;

    @Override
    public BreedDto findById(Long id) {
        return BreedDto.of(breedRepository.findById(id).orElseThrow(() -> new ServiceException(BreedError.BREED_NOT_FOUND)));
    }

    @Override
    public Breed getById(Long id) {
        return breedRepository.findById(id).orElseThrow(() -> new ServiceException(BreedError.BREED_NOT_FOUND));
    }

    @Override
    public List<BreedDto> getAll() {
        return breedRepository.findAll().stream().map(BreedDto::of).collect(Collectors.toList());
    }

    @Override
    public BreedDto create(Breed breed) {
        return BreedDto.of(breedRepository.save(breed));
    }

    @Override
    public BreedDto update(Breed breed) {
        return BreedDto.of(breedRepository.save(breed));
    }

    @Override
    public void delete(Long id) {
        final Breed breed = breedRepository.findById(id).orElseThrow(() -> new ServiceException(BreedError.BREED_NOT_FOUND));
        breedRepository.delete(breed);
    }
}
