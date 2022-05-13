package tr.edu.ege.petinder.animalservice.exception;

import org.springframework.http.HttpStatus;

public enum PetError implements ApiError {

    PET_NOT_FOUND("Pet Not Found!", HttpStatus.NOT_FOUND),
    PET_ALREADY_REGISTERED("Pet already registered!", HttpStatus.CONFLICT);

    private String message;
    private HttpStatus httpStatus;

    PetError(String message, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
