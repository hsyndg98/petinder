package tr.edu.ege.petinder.matchingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.ege.petinder.matchingservice.model.Mating;

import java.util.List;

@Repository
public interface MatingRepository extends JpaRepository<Mating,Long> {

    List<Mating> getAllByIsDoneIsFalse();
    List<Mating> getAllByIsDoneIsTrue();
}
