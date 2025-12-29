package com.example.ExceptionHandling._2.repository;

import com.example.ExceptionHandling._2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{
}
