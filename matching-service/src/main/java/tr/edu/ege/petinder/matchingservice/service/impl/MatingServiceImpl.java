package tr.edu.ege.petinder.matchingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.edu.ege.petinder.matchingservice.dto.mating.MatingDto;
import tr.edu.ege.petinder.matchingservice.dto.mating.MatingResponseDto;
import tr.edu.ege.petinder.matchingservice.model.Mating;
import tr.edu.ege.petinder.matchingservice.repository.MatingRepository;
import tr.edu.ege.petinder.matchingservice.service.MatingService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatingServiceImpl implements MatingService {

    private final MatingRepository matingRepository;

    @Override
    public MatingResponseDto create(MatingDto matingDto) {
        Mating mating = Mating.of(matingDto);
        return MatingResponseDto.of(matingRepository.save(mating));
    }

    @Override
    public void delete(Long id) {
        matingRepository.deleteById(id);
    }

    @Override
    public void updateIsDone(Long id, boolean isDone) {
        Mating mating = matingRepository.getById(id);
        mating.setDone(isDone);
    }

    @Override
    public List<MatingResponseDto> getAll(boolean isDone) {
        if (!isDone) {
            return matingRepository.getAllByIsDoneIsFalse().stream()
                    .map(MatingResponseDto::of)
                    .collect(Collectors.toList());
        }
        return matingRepository.getAllByIsDoneIsTrue().stream()
                .map(MatingResponseDto::of)
                .collect(Collectors.toList());
    }
}
