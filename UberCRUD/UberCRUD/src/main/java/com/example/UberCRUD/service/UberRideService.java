package com.example.UberCRUD.service;

import com.example.UberCRUD.entity.UberRide;
import com.example.UberCRUD.repository.UberRideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UberRideService
{
    private final UberRideRepository repository;

    public UberRideService(UberRideRepository repository)
    {
        this.repository = repository;
    }

    public UberRide saveRide(UberRide ride)
    {
        return repository.save(ride);
    }

    public List<UberRide> getAllRides()
    {
        return repository.findAll();
    }

    public UberRide getRideById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public UberRide updateRide(Long id, UberRide ride)
    {
        UberRide existingRide = repository.findById(id).orElse(null);

        if (existingRide != null)
        {
            existingRide.setDriverName(ride.getDriverName());
            existingRide.setRiderName(ride.getRiderName());
            existingRide.setPickupLocation(ride.getPickupLocation());
            existingRide.setDropLocation(ride.getDropLocation());
            existingRide.setFare(ride.getFare());
            existingRide.setStatus(ride.getStatus());
            return repository.save(existingRide);
        }
        return null;
    }
    public void deleteRide(Long id)
    {
        repository.deleteById(id);
    }
}
