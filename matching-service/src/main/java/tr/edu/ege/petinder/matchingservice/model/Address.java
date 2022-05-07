package tr.edu.ege.petinder.matchingservice.model;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address extends BaseEntity {

    private String street;

    private String city;

    private String state;

    private String country;

}
