package com.example.CropCRUD.controller;

import com.example.CropCRUD.entity.Crop;
import com.example.CropCRUD.service.CropService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crops")
public class CropController
{
    private final CropService cropService;

    public CropController(CropService cropService)
    {
        this.cropService = cropService;
    }

    @PostMapping
    public Crop createCrop(@RequestBody Crop crop)
    {
        return cropService.addCrop(crop);
    }

    @GetMapping
    public List<Crop> getAllCrops()
    {
        return cropService.getAllCrops();
    }

    @GetMapping("/{id}")
    public Crop getCrop(@PathVariable Long id)
    {
        return cropService.getCropById(id);
    }

    @PutMapping("/{id}")
    public Crop updateCrop(@PathVariable Long id,
                           @RequestBody Crop crop)
    {
        return cropService.updateCrop(id, crop);
    }

    @DeleteMapping("/{id}")
    public String deleteCrop(@PathVariable Long id)
    {
        cropService.deleteCrop(id);
        return "crop deleted successfully";
    }
}
