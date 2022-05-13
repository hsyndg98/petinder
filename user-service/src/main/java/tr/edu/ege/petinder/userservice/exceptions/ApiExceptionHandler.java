package tr.edu.ege.petinder.userservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex, HttpServletRequest request) {
        ApiError apiError = ex.getApiError();
        return ResponseEntity.status(apiError.getStatus()).body(ErrorResponse.builder()
                .message(apiError.getMessage())
                .path(request.getContextPath())
                .statusCode(apiError.getStatus().value())
                .build());
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers, HttpStatus status,
                                                               WebRequest request) {
        return ResponseEntity.status(status.value()).body(ErrorResponse.builder()
                .message(ex.getMessage())
                .path(request.getContextPath())
                .statusCode(status.value())
                .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {
        log.error("Exception:", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.builder()
                .message(ex.getMessage())
                .path(request.getContextPath())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build());
    }
}
