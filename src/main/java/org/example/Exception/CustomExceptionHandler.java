package org.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<?> handleResourceNotFoundException(
            ResourceNotFoundException exception,
            WebRequest request
    ) {
        return new ResponseEntity<>(buildErrorBody(exception, request), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ResourceBadRequestException.class})
    public ResponseEntity<?> handleResourceBadRequestException(
            ResourceBadRequestException exception,
            WebRequest request
    ) {
        return new ResponseEntity<>(buildErrorBody(exception, request), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleValidationException (
            MethodArgumentNotValidException exception,
            WebRequest request
    ) {
        return new ResponseEntity<>(buildErrorBody(exception, request), HttpStatus.BAD_REQUEST);
    }

    public Map<String, Object> buildErrorBody (
            Exception exception,
            WebRequest request
    ) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());

        if (exception instanceof MethodArgumentNotValidException ex) {
            Map<String, Object> fieldErrors = new HashMap<>();
            ex.getBindingResult().getFieldErrors().forEach(
                    error -> fieldErrors.put(error.getField(), error.getDefaultMessage())
            );
            body.put("message", fieldErrors);
        } else {
            body.put("message", exception.getMessage());
        }

        body.put("path", request.getDescription(false));

        return body;
    }
}
