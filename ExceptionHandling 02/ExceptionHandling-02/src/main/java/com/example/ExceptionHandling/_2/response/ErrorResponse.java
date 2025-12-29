package com.example.ExceptionHandling._2.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse
{
    private String message;
    private int status;
    private LocalDate date;
}
