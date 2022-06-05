package tr.edu.ege.petinder.matchingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.edu.ege.petinder.matchingservice.dto.mating.MatingDto;
import tr.edu.ege.petinder.matchingservice.dto.mating.MatingResponseDto;
import tr.edu.ege.petinder.matchingservice.service.MatingService;

import java.util.List;

@RestController
@RequestMapping("api/v1/mating")
@RequiredArgsConstructor
public class MatingController {

    private final MatingService matingService;

    @PostMapping
    public MatingResponseDto create(@RequestBody MatingDto matingDto) {
        return matingService.create(matingDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        matingService.delete(id);
    }

    @PatchMapping
    public void updateIsDone(@RequestParam Long id,
                             @RequestParam boolean isDone) {
        matingService.updateIsDone(id, isDone);
    }

    @GetMapping
    public List<MatingResponseDto> getAll(@RequestParam boolean isDone) {
        return matingService.getAll(isDone);
    }
}
