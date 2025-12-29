package com.example.ResponseEntity.controller;

import com.example.ResponseEntity.entity.Hospital;
import com.example.ResponseEntity.responses.HospitalResponse;
import com.example.ResponseEntity.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService service;

    // CREATE
    @PostMapping
    public ResponseEntity<HospitalResponse<Hospital>> saveHospital(
            @RequestBody Hospital hospital) {

        Hospital saved = service.saveHospital(hospital);

        HospitalResponse<Hospital> response =
                new HospitalResponse<>(
                        "Hospital created",
                        LocalDate.now(),
                        saved,
                        HttpStatus.CREATED.toString()
                );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse<Hospital>> getHospitalById(
            @PathVariable Long id) {

        Hospital hospital = service.getHospitalById(id);

        HospitalResponse<Hospital> response =
                new HospitalResponse<>(
                        "Get By ID",
                        LocalDate.now(),
                        hospital,
                        HttpStatus.OK.toString()
                );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<HospitalResponse<List<Hospital>>> getAllHospitals() {

        List<Hospital> hospitals = service.getAllHospitals();

        HospitalResponse<List<Hospital>> response =
                new HospitalResponse<>(
                        "Get All Hospitals",
                        LocalDate.now(),
                        hospitals,
                        HttpStatus.OK.toString()
                );

        return ResponseEntity.ok(response);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<HospitalResponse<Hospital>> updateHospital(
            @PathVariable Long id,
            @RequestBody Hospital hospital) {

        Hospital updated = service.updateHospital(id, hospital);

        HospitalResponse<Hospital> response =
                new HospitalResponse<>(
                        "Hospital Updated",
                        LocalDate.now(),
                        updated,
                        HttpStatus.OK.toString()
                );

        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<HospitalResponse<String>> deleteHospital(
            @PathVariable Long id) {

        service.deleteHospital(id);

        HospitalResponse<String> response =
                new HospitalResponse<>(
                        "Hospital Deleted",
                        LocalDate.now(),
                        "Deleted Successfully",
                        HttpStatus.OK.toString()
                );

        return ResponseEntity.ok(response);
    }
}
