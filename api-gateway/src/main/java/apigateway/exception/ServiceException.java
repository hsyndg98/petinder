package apigateway.exception;

public class ServiceException extends Throwable {
    private final ApiError apiError;

    public ServiceException(ApiError apiError) {
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }
}
