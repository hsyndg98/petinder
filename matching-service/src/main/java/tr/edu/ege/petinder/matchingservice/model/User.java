package tr.edu.ege.petinder.matchingservice.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User extends BaseEntity {

    private String name;

    private String surname;

    private String email;

    private String password;

    private String phoneNumber;

    private String profilePicture;

    @Lob
    @Column(length = 2500)
    private String bio;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Pet> pets;

}
