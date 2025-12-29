package com.example.SwaggerCRUD.responses;

import java.time.LocalDateTime;

public class ApiResponse<T>
{
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public ApiResponse(String message, T data)
    {
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
}
