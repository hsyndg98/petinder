package tr.edu.ege.petinder.matchingservice.model;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Animal extends BaseEntity {

    private String name;
    private String color;
    private String age;

}
