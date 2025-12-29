package com.example.ResponseEntity._4.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T>
{
    private String message;
    private LocalDateTime timestamp;
    private T data;
    private int status;
}
