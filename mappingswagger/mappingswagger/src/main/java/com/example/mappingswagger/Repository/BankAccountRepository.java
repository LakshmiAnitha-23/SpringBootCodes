package com.example.mappingswagger.Repository;

import com.example.mappingswagger.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>
{
}
