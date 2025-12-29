package com.example.ResponseEntity._6.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiResponse<T>
{
    private String message;
    private T data;
    private LocalDateTime timestamp;
}
