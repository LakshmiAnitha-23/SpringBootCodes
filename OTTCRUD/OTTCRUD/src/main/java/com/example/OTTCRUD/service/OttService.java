package com.example.OTTCRUD.service;

import com.example.OTTCRUD.entity.OttPlatform;
import com.example.OTTCRUD.repository.OttRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OttService
{
    private final OttRepository repository;

    public OttService(OttRepository repository)
    {
        this.repository = repository;
    }

    public OttPlatform saveOtt(OttPlatform ott)
    {
        return repository.save(ott);
    }

    public List<OttPlatform> getAllOtts()
    {
        return repository.findAll();
    }

    public OttPlatform getOttById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public OttPlatform updateOtt(Long id, OttPlatform ott)
    {
        OttPlatform existing = repository.findById(id).orElse(null);
        if(existing != null)
        {
            existing.setName(ott.getName());
            existing.setSubscriptionType(ott.getSubscriptionType());
            existing.setPrice(ott.getPrice());
            existing.setLanguage(ott.getLanguage());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteOtt(Long id)
    {
        repository.deleteById(id);
    }
}
