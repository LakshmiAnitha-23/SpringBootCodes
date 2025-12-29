package com.example.ResponseEntity03.responses;

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
    private LocalDateTime time;
    private T data;
    private int status;
}
