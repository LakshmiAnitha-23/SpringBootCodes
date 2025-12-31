package com.example.BooksDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.BooksDemo.responses.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleBookNotFound(
            BookNotFoundException ex)

    {
        ApiResponse<String> response = new ApiResponse<>(ex.getMessage(), null);
        return  ResponseEntity.status( HttpStatus.NOT_FOUND).body(response);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGenericException(Exception ex)
    {
        ApiResponse<String> response = new ApiResponse<>("internal Server Error", null);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
