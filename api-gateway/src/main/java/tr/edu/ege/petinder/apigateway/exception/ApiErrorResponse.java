package tr.edu.ege.petinder.apigateway.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiErrorResponse {
    private String message;
    private String path;
    private LocalDateTime localDateTime;
}
