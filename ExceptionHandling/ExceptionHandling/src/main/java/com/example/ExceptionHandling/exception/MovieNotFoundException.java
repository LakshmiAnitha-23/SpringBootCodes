package com.example.ExceptionHandling.exception;

public class MovieNotFoundException extends RuntimeException
{
    public MovieNotFoundException(String message)
    {
        super(message);
    }
}
