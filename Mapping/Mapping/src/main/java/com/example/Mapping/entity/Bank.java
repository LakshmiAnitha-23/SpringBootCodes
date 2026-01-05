package com.example.Mapping.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bank
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;
    private String branch;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;
}
