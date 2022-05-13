package tr.edu.ege.petinder.animalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.ege.petinder.animalservice.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
