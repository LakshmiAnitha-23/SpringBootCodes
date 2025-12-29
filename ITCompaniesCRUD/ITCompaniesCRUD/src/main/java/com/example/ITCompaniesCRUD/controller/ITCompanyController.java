package com.example.ITCompaniesCRUD.controller;

import com.example.ITCompaniesCRUD.entity.ITCompany;
import com.example.ITCompaniesCRUD.responses.ITCompanyResponse;
import com.example.ITCompaniesCRUD.service.ITCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class ITCompanyController
{
    @Autowired
    private ITCompanyService service;

    @PostMapping
    public ITCompany createCompany(@RequestBody ITCompany company)
    {
        return service.saveCompany(company);
    }

    @GetMapping
    public List<ITCompany> getAllCompanies()
    {
        return service.getAllCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ITCompanyResponse<ITCompany>> getCompanyById(@PathVariable Long id)
    {
        ITCompany companyById = service.getCompanyById(id);
        ITCompanyResponse<ITCompany> response = new ITCompanyResponse<>("Get By ID", LocalDate.now(), companyById, HttpStatus.OK.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ITCompany updateCompany(@PathVariable Long id,
                                   @RequestBody ITCompany company) {
        return service.updateCompany(id, company);
    }
    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable Long id)
    {
        service.deleteCompany(id);
        return "company deleted successfully";
    }
}

