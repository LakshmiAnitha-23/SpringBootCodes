package com.example.ITCompaniesCRUD.repository;

import com.example.ITCompaniesCRUD.entity.ITCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITCompanyRepository extends JpaRepository<ITCompany, Long>
{
}
