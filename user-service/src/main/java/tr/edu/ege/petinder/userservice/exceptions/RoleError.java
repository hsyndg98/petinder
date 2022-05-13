package tr.edu.ege.petinder.userservice.exceptions;

import org.springframework.http.HttpStatus;

public enum RoleError implements ApiError {

    ROLE_NOT_FOUND("Role not found", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus status;

    RoleError(String message, HttpStatus status) {
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
