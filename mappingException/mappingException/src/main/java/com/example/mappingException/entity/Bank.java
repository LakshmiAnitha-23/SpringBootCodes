package com.example.mappingException.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "banks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;
    private String branch;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Account> accounts = new ArrayList<>();
}
