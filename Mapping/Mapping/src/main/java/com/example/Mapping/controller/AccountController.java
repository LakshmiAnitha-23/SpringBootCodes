package com.example.Mapping.controller;

import com.example.Mapping.entity.Account;
import com.example.Mapping.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@Tag(name = "Bank Account APIs")
public class AccountController
{
    @Autowired
    private AccountService service;

    @PostMapping
    @Operation(summary = "create Bank Account")
    public ResponseEntity<Account> create(@RequestBody Account account)
    {
        return ResponseEntity.ok(service.saveAccount(account));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Account By ID")
    public ResponseEntity<Account> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getAccount(id));
    }
}
