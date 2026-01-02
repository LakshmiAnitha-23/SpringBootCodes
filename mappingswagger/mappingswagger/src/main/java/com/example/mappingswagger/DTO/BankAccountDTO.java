package com.example.mappingswagger.DTO;

import lombok.Data;

@Data
public class BankAccountDTO
{
    private String accountNumber;
    private Double balance;
    private AccountHolderDTO holder;
}
