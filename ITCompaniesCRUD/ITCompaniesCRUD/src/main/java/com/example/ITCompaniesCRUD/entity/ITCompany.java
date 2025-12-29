package com.example.ITCompaniesCRUD.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@Table(name="it_companies")
public class ITCompany
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private int employees;

    public ITCompany() {}

    public ITCompany(String name, String location, int employees)
    {
        this.name = name;
        this.location = location;
        this.employees = employees;
    }


}
