package com.example.ResponseEntity.service;

import com.example.ResponseEntity.entity.Hospital;
import com.example.ResponseEntity.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService
{
    @Autowired
    private HospitalRepository repository;

    @Override
    public Hospital saveHospital(Hospital hospital)
    {
        return repository.save(hospital);
    }

    @Override
    public Hospital getHospitalById(Long id)
    {
        return repository.findById(id).orElseThrow();
    }
    @Override
    public List<Hospital> getAllHospitals()
    {
       return repository.findAll();
    }

    @Override
    public Hospital updateHospital(Long id, Hospital hospital)
    {
        Hospital existing = repository.findById(id).orElseThrow();
        existing.setName(hospital.getName());
        existing.setLocation(hospital.getLocation());
        existing.setBeds(hospital.getBeds());
        return repository.save(existing);
    }

    @Override
    public void deleteHospital(Long id)
    {
        repository.deleteById(id);
    }
}
