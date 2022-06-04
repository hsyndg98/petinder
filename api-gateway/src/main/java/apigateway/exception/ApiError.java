package apigateway.exception;

import org.springframework.http.HttpStatus;

public interface ApiError {
    HttpStatus getHttpStatus();
    String getMessage();

}
