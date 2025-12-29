package com.example.ResponseEntity.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponse<T>
{
    private String message;
    private LocalDate localDate;
    private T data;
    private String httpStatus;
}
