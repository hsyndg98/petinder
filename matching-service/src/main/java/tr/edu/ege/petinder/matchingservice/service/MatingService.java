package tr.edu.ege.petinder.matchingservice.service;

import tr.edu.ege.petinder.matchingservice.dto.mating.MatingDto;
import tr.edu.ege.petinder.matchingservice.dto.mating.MatingResponseDto;
import tr.edu.ege.petinder.matchingservice.model.Mating;

import java.util.List;

public interface MatingService {
    MatingResponseDto create(MatingDto matingDto);

    void delete(Long id);

    void updateIsDone(Long id, boolean isDone);

    List<MatingResponseDto> getAll(boolean isDone);

}
