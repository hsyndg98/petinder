package tr.edu.ege.petinder.animalservice.model;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vaccine extends BaseEntity{

    private String date;
}
