package tr.edu.ege.petinder.userservice.exceptions;

public class ServiceException extends RuntimeException {
    private ApiError apiError;

    public ServiceException(ApiError apiError) {
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }
}
