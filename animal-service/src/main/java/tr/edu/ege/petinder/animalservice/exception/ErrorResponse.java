package tr.edu.ege.petinder.animalservice.exception;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private String message;

    private int statusCode;

    private Date timestamp;

    private List<String> errors;

    private String path;
}
