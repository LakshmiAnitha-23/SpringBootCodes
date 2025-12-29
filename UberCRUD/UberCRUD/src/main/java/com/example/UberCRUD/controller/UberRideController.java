package com.example.UberCRUD.controller;

import com.example.UberCRUD.entity.UberRide;
import com.example.UberCRUD.service.UberRideService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uber")
public class UberRideController
{
    private final UberRideService service;

    public UberRideController(UberRideService service)
    {
        this.service = service;
    }

    @PostMapping("/ride")
    public UberRide createRide(@RequestBody UberRide ride)
    {
        return service.saveRide(ride);
    }

    @GetMapping("/rides")
    public List<UberRide> getAllRides()
    {
        return service.getAllRides();
    }

    @GetMapping("/ride/{id}")
    public UberRide getRideById(@PathVariable Long id)
    {
        return service.getRideById(id);
    }

    @PutMapping("/ride/{id}")
    public UberRide updateRide(@PathVariable Long id,
                               @RequestBody UberRide ride)
    {
        return service.updateRide(id, ride);
    }

    @DeleteMapping("/ride/{id}")
    public String deleteRide(@PathVariable Long id)
    {
        service.deleteRide(id);
        return "Ride deleted successfully";
    }
}
