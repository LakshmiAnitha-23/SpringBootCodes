package com.example.ResponseEntity._6.exception;

import com.example.ResponseEntity._6.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleStudentNotFound(StudentNotFoundException ex)
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
                new ApiResponse<>("Internal server Error", ex.getMessage(), LocalDateTime.now()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
