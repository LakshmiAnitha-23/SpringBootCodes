package com.example.ResponseEntity03.service;

import com.example.ResponseEntity03.entity.Rapido;
import com.example.ResponseEntity03.repository.RapidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapidoService
{
    private final RapidoRepository repository;

    public RapidoService(RapidoRepository repository)
    {
        this.repository = repository;
    }

    public Rapido saveRide(Rapido rapido)
    {
        return repository.save(rapido);
    }

    public List<Rapido> getAllRides()
    {
        return repository.findAll();
    }

    public Rapido getRideById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public Rapido updateRide(Long id, Rapido rapido)
    {
        rapido.setRideId(id);
        return repository.save(rapido);
    }

    public void deleteRide(Long id)
    {
        repository.deleteById(id);
    }
}
