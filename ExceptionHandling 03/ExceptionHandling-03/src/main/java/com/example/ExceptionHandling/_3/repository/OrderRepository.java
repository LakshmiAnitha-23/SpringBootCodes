package com.example.ExceptionHandling._3.repository;

import com.example.ExceptionHandling._3.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long>
{
}
