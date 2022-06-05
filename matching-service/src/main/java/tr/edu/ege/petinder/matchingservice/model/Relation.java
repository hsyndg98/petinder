package tr.edu.ege.petinder.matchingservice.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class Relation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long petOwnerId;

    private Long requesterId;


    private boolean isApproved;

    @Builder.Default()
    private boolean isReplied=false;

    @Builder.Default
    private boolean isDone=false;

    @CreationTimestamp
    @CreatedDate
    private Date createdAt;


    @LastModifiedDate
    @UpdateTimestamp
    private Date updatedAt;
}
