package com.example.ITCompaniesCRUD.service;

import com.example.ITCompaniesCRUD.entity.ITCompany;
import com.example.ITCompaniesCRUD.repository.ITCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITCompanyService
{
    @Autowired
    private ITCompanyRepository repository;

        public ITCompany saveCompany(ITCompany company)
        {
            return repository.save(company);
        }

        public List<ITCompany> getAllCompanies()
        {
            return repository.findAll();
        }

        public ITCompany getCompanyById(Long id)
        {
            return repository.findById(id).orElse(null);
        }

        public ITCompany updateCompany(Long id, ITCompany company)
        {
            ITCompany existing = repository.findById(id).orElse(null);
            if(existing != null)
            {
                existing.setName(company.getName());
                existing.setLocation(company.getLocation());
                existing.setEmployees(company.getEmployees());
                return repository.save(existing);
            }
            return null;
        }

        public void deleteCompany(Long id)
        {
            repository.deleteById(id);
        }
    }

