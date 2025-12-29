package com.example.ResponseEntity._4.service;

import com.example.ResponseEntity._4.entity.SwiggyOrder;
import com.example.ResponseEntity._4.repository.SwiggyOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwiggyOrderService
{
    private final SwiggyOrderRepository repository;

    public SwiggyOrderService(SwiggyOrderRepository repository)
    {
        this.repository = repository;
    }

    public SwiggyOrder createOrder(SwiggyOrder order)
    {
        return repository.save(order);
    }

    public List<SwiggyOrder> getAllOrders()
    {
        return repository.findAll();
    }

    public SwiggyOrder getOrderById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public SwiggyOrder updateOrder(Long id, SwiggyOrder order)
    {
        order.setOrderId(id);
        return repository.save(order);
    }

    public void deleteOrder(Long id)
    {
        repository.deleteById(id);
    }
}
