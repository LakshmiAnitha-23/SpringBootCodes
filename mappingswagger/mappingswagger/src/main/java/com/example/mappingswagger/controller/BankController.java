package com.example.mappingswagger.controller;

import com.example.mappingswagger.DTO.BankAccountDTO;
import com.example.mappingswagger.Repository.BankAccountRepository;
import com.example.mappingswagger.entity.AccountHolder;
import com.example.mappingswagger.entity.BankAccount;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
@RequiredArgsConstructor
@Tag(name="Bank Account API", description = "operations related to bank accounts")
public class BankController
{
    private final BankAccountRepository repository;

    @Operation(summary = "create Bank Account")
    @ApiResponse(responseCode = "201", description = "Account created successfully")
    @PostMapping("/accounts")
    public ResponseEntity<BankAccount> createAccount(
            @RequestBody BankAccountDTO dto)
    {
        BankAccount account = new BankAccount();
        account.setAccountNumber(dto.getAccountNumber());
        account.setBalance(dto.getBalance());

        AccountHolder holder = new AccountHolder();
        holder.setName(dto.getHolder().getName());
        holder.setEmail(dto.getHolder().getEmail());

        account.setHolder(holder);

        return new ResponseEntity<>(
                repository.save(account),
                HttpStatus.CREATED
        );
    }

    @Operation(summary = "Get Account By ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Account found"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })

    @GetMapping("/accounts/{id}")
    public ResponseEntity<BankAccount> getAccount(
            @PathVariable Long id)
    {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "update Account Balance")
    @PatchMapping("/accounts/{id}")
    public ResponseEntity<String> updateBalance(
            @PathVariable Long id,
            @RequestParam Double balance)
    {
        BankAccount account = repository.findById(id).orElseThrow();
        account.setBalance(balance);
        repository.save(account);

        return ResponseEntity.ok("Balance updated");
    }


    @Operation(summary = "Delete Account")
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<String> deleteAccount(
            @PathVariable Long id)
    {
        repository.deleteById(id);
        return ResponseEntity.ok("Account deleted");
    }


}
