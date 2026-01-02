package com.example.mappingException.controller;

import com.example.mappingException.entity.Account;
import com.example.mappingException.entity.Bank;
import com.example.mappingException.exception.ResourceNotFoundException;
import com.example.mappingException.repository.AccountRepository;
import com.example.mappingException.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;

@RestController
@RequestMapping("/api/bank")
@RequiredArgsConstructor
public class BankController
{
    private final BankRepository bankRepo;
    private final AccountRepository accountRepo;

    @PostMapping("/banks")
    public Bank createBank(@RequestBody Bank bank)
    {
        return bankRepo.save(bank);
    }

    @GetMapping("/banks/{id}")
    public Bank getBank(@PathVariable Long id)
    {
        return bankRepo.findById(id)
                .orElseThrow(() -> new ResolutionException("Bank not found with id" + id));
    }

    @PostMapping("/banks/{bankId}/accounts")
    public Account createAccount(
            @PathVariable Long bankId,
            @RequestBody Account account)
    {
        Bank bank = bankRepo.findById(bankId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found"));

        account.setBank(bank);
        return accountRepo.save(account);
    }

    @PatchMapping("/accounts/{id}")
    public String updateBalance(
            @PathVariable Long id,
            @RequestParam Double balance)
    {
        Account account = accountRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Account not found"));

        account.setBalance(balance);
        accountRepo.save(account);
        return "Balance updated successfully";
    }
}
