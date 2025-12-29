package com.example.CropCRUD.repository;

import com.example.CropCRUD.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long>
{
}
