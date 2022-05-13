package tr.edu.ege.petinder.userservice.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Pet extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
