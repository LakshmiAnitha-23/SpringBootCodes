package com.example.ResponseEntity02.repository;

import com.example.ResponseEntity02.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{
}
