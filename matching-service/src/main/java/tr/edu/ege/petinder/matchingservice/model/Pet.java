package tr.edu.ege.petinder.matchingservice.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pet extends Specie {

    private String name;
    private String age;
    private String description;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Specie speciesSet;
}
