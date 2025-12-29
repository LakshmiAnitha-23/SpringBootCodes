package com.example.SwaggerCRUD.repository;

import com.example.SwaggerCRUD.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{
}
