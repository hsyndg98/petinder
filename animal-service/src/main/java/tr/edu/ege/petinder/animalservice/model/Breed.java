package tr.edu.ege.petinder.animalservice.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Breed extends BaseEntity{

    private String name;

    @Enumerated(EnumType.STRING)
    private Animal animal;

}
