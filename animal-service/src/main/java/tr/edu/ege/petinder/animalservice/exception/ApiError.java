package tr.edu.ege.petinder.animalservice.exception;

import org.springframework.http.HttpStatus;

public interface ApiError {

    HttpStatus getHttpStatus();

    String getMessage();
}