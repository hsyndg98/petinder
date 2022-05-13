package tr.edu.ege.petinder.animalservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.ege.petinder.animalservice.dto.breed.BreedDto;
import tr.edu.ege.petinder.animalservice.model.Breed;
import tr.edu.ege.petinder.animalservice.service.BreedService;
import tr.edu.ege.petinder.animalservice.common.response.GenericResponse;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/breed")
public class BreedController {

    private final BreedService breedService;

    @GetMapping
    public ResponseEntity<BreedDto> getBreed(@RequestParam Long id){
        return ResponseEntity.ok(breedService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BreedDto>> getAllBreed(){
        return ResponseEntity.ok(breedService.getAll());
    }

    @PostMapping
    public ResponseEntity<BreedDto> create(@RequestBody Breed breed){

        return ResponseEntity.ok(breedService.create(breed));
    }
    @PutMapping
    public ResponseEntity<BreedDto> update(@RequestBody Breed breed){
        return ResponseEntity.ok(breedService.update(breed));
    }

    @DeleteMapping
    public ResponseEntity<GenericResponse> delete(@RequestParam Long id){

        breedService.delete(id);
        return ResponseEntity.ok(new GenericResponse("Başarıyla silindi"));
    }
}
