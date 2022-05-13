package tr.edu.ege.petinder.userservice.exceptions;

import org.springframework.http.HttpStatus;

public interface ApiError {

    String getMessage();

    HttpStatus getStatus();

}
