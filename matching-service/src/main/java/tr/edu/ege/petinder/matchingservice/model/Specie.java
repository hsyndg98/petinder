package tr.edu.ege.petinder.matchingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter

public class Specie extends Animal
{
    private String specieName;


}
