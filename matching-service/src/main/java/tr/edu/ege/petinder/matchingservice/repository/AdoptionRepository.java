package tr.edu.ege.petinder.matchingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.ege.petinder.matchingservice.model.Adoption;

import java.util.List;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    List<Adoption> findAllByIsApprovedIsTrue();
    List<Adoption> findAllByIsApprovedIsFalse();
}
