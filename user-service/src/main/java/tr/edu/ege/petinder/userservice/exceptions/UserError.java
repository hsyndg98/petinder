package tr.edu.ege.petinder.userservice.exceptions;

import org.springframework.http.HttpStatus;

public enum UserError implements ApiError {

    USER_NOT_FOUND("User not found", HttpStatus.NOT_FOUND),
    USERNAME_ALREADY_REGISTERED("This username already registered", HttpStatus.CONFLICT),

    USER_EMAIL_ALREADY_REGISTERED("This email already registered", HttpStatus.CONFLICT),
    PHONE_NUMBER_ALREADY_REGISTERED("This phone number already registered", HttpStatus.CONFLICT);



    private final String message;
    private final HttpStatus status;

    UserError(String message, HttpStatus status) {
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
