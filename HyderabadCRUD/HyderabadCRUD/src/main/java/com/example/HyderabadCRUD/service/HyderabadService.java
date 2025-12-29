package com.example.HyderabadCRUD.service;

import com.example.HyderabadCRUD.entity.Hyderabad;
import com.example.HyderabadCRUD.repository.HyderabadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HyderabadService
{
    private final HyderabadRepository repository;

    public HyderabadService(HyderabadRepository repository)
    {
        this.repository = repository;
    }

    public Hyderabad saveHyderabad(Hyderabad h)
    {
        return repository.save(h);
    }

    public List<Hyderabad> getAll()
    {
        return repository.findAll();
    }

    public Hyderabad getById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public Hyderabad updateHyderabad(Long id,Hyderabad h)
    {
        Hyderabad existing = repository.findById(id).orElse(null);
        if(existing != null)
        {
            existing.setAreaName(h.getAreaName());
            existing.setAreaName(h.getAreaName());
            existing.setPopulation(h.getPopulation());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteHyderabad(Long id)
    {
        repository.deleteById(id);
    }
}
