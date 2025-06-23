package com.gosuto.productservice.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Hidden
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(value = { Exception.class })
    public ErrorResponse handleException(Exception exception) {
        return ErrorResponse.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value() + "")
                .message(exception.getMessage())
                .timestamp(Instant.now())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(value = { RessourceNotFoundException.class })
    public ErrorResponse handleException(RessourceNotFoundException exception) {
        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value() + "")
                .message(exception.getMessage())
                .timestamp(Instant.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(value = { RessourceException.class })
    public ErrorResponse handleException(RessourceException exception) {
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value() + "")
                .message(exception.getMessage())
                .timestamp(Instant.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public Map<String, String> handleValidationsException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach((error) -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return errors;
    }

    @Data
    @AllArgsConstructor
    @Builder
    public static class ErrorResponse {
        private String code;
        private String message;
        private Instant timestamp;
    }

}
