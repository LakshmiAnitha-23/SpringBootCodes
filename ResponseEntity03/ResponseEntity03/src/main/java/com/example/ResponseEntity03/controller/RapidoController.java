package com.example.ResponseEntity03.controller;

import com.example.ResponseEntity03.entity.Rapido;
import com.example.ResponseEntity03.responses.ApiResponse;
import com.example.ResponseEntity03.service.RapidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/rapido")
public class RapidoController
{
    private final RapidoService service;

    public RapidoController(RapidoService service)
    {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Rapido>> createRide(@RequestBody Rapido rapido)
    {
        Rapido saved = service.saveRide(rapido);

        ApiResponse<Rapido> response =
                new ApiResponse<>("Ride created successfully",
                        LocalDateTime.now(),
                        saved,
                        HttpStatus.CREATED.value());
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Rapido>>> getAllRides()
    {
        ApiResponse<List<Rapido>> response =
                new ApiResponse<>("All Rides Fetched",
                        LocalDateTime.now(),
                        service.getAllRides(),
                        HttpStatus.OK.value());
        return ResponseEntity.ok(response);
        }

        @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Rapido>> getRide(@PathVariable Long id)
        {
            Rapido ride = service.getRideById(id);
            ApiResponse<Rapido> response =
                    new ApiResponse<>("Ride Found",
                            LocalDateTime.now(),
                            ride,
                            HttpStatus.OK.value());

            return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Rapido>> updateRide(
            @PathVariable Long id,
            @RequestBody Rapido rapido)
    {
        ApiResponse<Rapido> response =
                new ApiResponse<>("Ride updated",
                        LocalDateTime.now(),
                        service.updateRide(id, rapido),
                        HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteRide(@PathVariable Long id)

    {
        service.deleteRide(id);
        ApiResponse<String> response =
                new ApiResponse<>("Ride Deleted",
                        LocalDateTime.now(),
                        "Deleted ID: " +id,
                        HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }
}
