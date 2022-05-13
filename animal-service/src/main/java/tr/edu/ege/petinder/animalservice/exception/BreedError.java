package tr.edu.ege.petinder.animalservice.exception;

import org.springframework.http.HttpStatus;

public enum BreedError implements ApiError{
    BREED_NOT_FOUND("Breed not found exception",HttpStatus.NOT_FOUND)
    ;

    private HttpStatus status;
    private String message;

    BreedError(String message,HttpStatus status){
        this.message = message;
        this.status = status;
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
