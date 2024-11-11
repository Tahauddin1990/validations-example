package com.tahauddin.syed.exceptions;

import com.tahauddin.syed.errors.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BeanValidationException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException (MethodArgumentNotValidException validException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setId(String.valueOf(System.currentTimeMillis()));
        Map<String, String> errors = new HashMap<>();
        validException.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        errorResponse.setErrorMessages(errors);
        errorResponse.setErrorTime(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }


}
