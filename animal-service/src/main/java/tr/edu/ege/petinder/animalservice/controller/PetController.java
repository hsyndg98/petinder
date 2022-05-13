package tr.edu.ege.petinder.animalservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.ege.petinder.animalservice.dto.pet.PetCreationDto;
import tr.edu.ege.petinder.animalservice.dto.pet.PetDetailsDto;
import tr.edu.ege.petinder.animalservice.service.PetService;
import tr.edu.ege.petinder.animalservice.common.response.GenericResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/pet")
public class PetController {

    private final PetService petService;

    @GetMapping
    public ResponseEntity<PetDetailsDto> getPetById(@RequestParam Long id) {
        return ResponseEntity.ok(petService.getPet(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PetDetailsDto>> getAllPet() {

        return ResponseEntity.ok(petService.getAllPets());
    }

    @PostMapping
    public ResponseEntity<PetDetailsDto> create(@RequestBody @Valid PetCreationDto petCreationDto) {
        return ResponseEntity.ok(petService.create(petCreationDto));
    }

    @PutMapping
    public ResponseEntity<PetDetailsDto> update(@RequestBody @Valid PetDetailsDto petDetailsDto) {
        return ResponseEntity.ok(petService.update(petDetailsDto));
    }

    @DeleteMapping
    public ResponseEntity<GenericResponse> delete(@RequestParam Long id) {
        petService.delete(id);
        return ResponseEntity.ok(new GenericResponse("Başarıyla silindi"));
    }
}
