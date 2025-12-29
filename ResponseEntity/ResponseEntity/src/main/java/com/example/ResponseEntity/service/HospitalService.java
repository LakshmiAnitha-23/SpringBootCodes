package com.example.ResponseEntity.service;

import com.example.ResponseEntity.entity.Hospital;

import java.util.List;

public interface HospitalService
{
    Hospital saveHospital(Hospital hospital);
    Hospital getHospitalById(Long id);
    List<Hospital> getAllHospitals();
    Hospital updateHospital(Long id, Hospital hospital);
    void deleteHospital(Long id);
}
