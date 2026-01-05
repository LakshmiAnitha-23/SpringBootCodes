package com.example.Mapping.service;

import com.example.Mapping.entity.Account;
import com.example.Mapping.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
public class AccountService
{
    @Autowired
    private AccountRepository repo;

    public Account saveAccount(Account account)
    {
        return repo.save(account);
    }

    public Account getAccount(Long id)
    {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
