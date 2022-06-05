package tr.edu.ege.petinder.matchingservice.exception;

import org.springframework.http.HttpStatus;

public enum MatingError implements ApiError {
    MATING_NOT_FOUND_ERROR("Mating not found exception", HttpStatus.NOT_FOUND);

    private HttpStatus status;
    private String message;

    MatingError(String message, HttpStatus httpStatus) {
        this.status = httpStatus;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.status;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
