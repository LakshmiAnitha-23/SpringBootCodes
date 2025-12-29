package com.example.ExceptionHandling.exception;

import com.example.ExceptionHandling.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleMovieNotFound(MovieNotFoundException ex)
    {
        return new ResponseEntity<>(
                new ApiResponse<>(ex.getMessage(), null, LocalDateTime.now()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGeneralException(Exception ex)
    {
        return new ResponseEntity<>(
                new ApiResponse<>("Internal server Error",
                        ex.getMessage(),
                        LocalDateTime.now()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
