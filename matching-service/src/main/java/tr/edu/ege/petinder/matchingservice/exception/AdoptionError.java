package tr.edu.ege.petinder.matchingservice.exception;

import org.springframework.http.HttpStatus;

public enum AdoptionError implements ApiError{
        ADOPTION_NOT_FOUND_ERROR("Adoption not found exception", HttpStatus.NOT_FOUND)
        ;

        private HttpStatus status;
        private String message;

        AdoptionError(String message,HttpStatus status){
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
