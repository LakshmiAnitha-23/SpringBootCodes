package com.example.ExceptionHandling._3.exception;

public class OrderNotFoundException extends RuntimeException
{
    public OrderNotFoundException(String message)
    {
        super(message);
    }
}
