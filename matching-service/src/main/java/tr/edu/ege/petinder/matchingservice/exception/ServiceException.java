package tr.edu.ege.petinder.matchingservice.exception;

public class ServiceException extends RuntimeException {

    private ApiError apiError;

    public ServiceException(ApiError apiError) {
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }
}
