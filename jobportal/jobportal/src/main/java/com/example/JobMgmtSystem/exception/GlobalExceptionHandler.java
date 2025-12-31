package com.example.JobMgmtSystem.exception;

import com.example.JobMgmtSystem.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleJobNotFound(JobNotFoundException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(
                        ex.getMessage(),
                        LocalDateTime.now(),
                        null,
                        "404"
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGeneric(Exception ex)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse<>(
                        "Internal Server Error",
                        LocalDateTime.now(),
                        ex.getMessage(),
                        "500"
                ));
    }
}
