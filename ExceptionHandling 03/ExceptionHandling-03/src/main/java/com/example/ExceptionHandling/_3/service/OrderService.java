package com.example.ExceptionHandling._3.service;

import com.example.ExceptionHandling._3.entity.Orders;
import com.example.ExceptionHandling._3.exception.OrderNotFoundException;
import com.example.ExceptionHandling._3.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;

    public Orders createOrder(Orders order)
    {
        return orderRepository.save(order);
    }

    public List<Orders> getAllOrders()
    {
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id)
    {
        Optional<Orders> optionalOrder = orderRepository.findById(id);

        if(optionalOrder.isEmpty())
        {
            throw new OrderNotFoundException("order not found with id: " + id);
        }

        return optionalOrder.get();
    }

    public Orders updateOrder(Long id, Orders order)
    {
        Orders existingOrder = getOrderById(id);

        existingOrder.setProductName(order.getProductName());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setPrice(order.getPrice());

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id)
    {
        Orders orders = getOrderById(id);
        orderRepository.delete(orders);
    }
}
