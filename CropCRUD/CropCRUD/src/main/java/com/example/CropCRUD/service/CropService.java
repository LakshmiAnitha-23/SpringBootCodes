package com.example.CropCRUD.service;

import com.example.CropCRUD.entity.Crop;
import com.example.CropCRUD.repository.CropRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService
{
    private final CropRepository cropRepository;

    public CropService(CropRepository cropRepository)
    {
        this.cropRepository = cropRepository;
    }

    public Crop addCrop(Crop crop)
    {
        return cropRepository.save(crop);
    }

    public List<Crop> getAllCrops()
    {
        return cropRepository.findAll();
    }

    public Crop getCropById(Long id)
    {
        return cropRepository.findById(id).orElse(null);
    }

    public Crop updateCrop(Long id, Crop crop)
    {
        Crop existing = cropRepository.findById(id).orElse(null);

        if(existing != null)
        {
            existing.setName(crop.getName());
            existing.setSeason(crop.getSeason());
            existing.setPricePerKg(crop.getPricePerKg());
            return cropRepository.save(existing);
        }
        return null;
    }

    public void deleteCrop(Long id)
    {
        cropRepository.deleteById(id);
    }
}
