package tr.edu.ege.petinder.userservice.exceptions;

import org.springframework.http.HttpStatus;

public enum AddressDtoError implements ApiError{
    ADDRESS_ERROR_EMPTY("Address not to be empty", HttpStatus.NOT_ACCEPTABLE);



    private final String message;
    private final HttpStatus status;

    AddressDtoError(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }
}
