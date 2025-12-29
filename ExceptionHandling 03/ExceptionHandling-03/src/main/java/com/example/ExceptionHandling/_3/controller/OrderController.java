package com.example.ExceptionHandling._3.controller;

import com.example.ExceptionHandling._3.entity.Orders;
import com.example.ExceptionHandling._3.response.ApiResponse;
import com.example.ExceptionHandling._3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<Orders>> createOrder(
            @RequestBody Orders order)
    {
        Orders savedOrder = orderService.createOrder(order);

        ApiResponse<Orders> response = new ApiResponse<>("order created successfully", 201, savedOrder);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Orders>>> getAllOrders()
    {
        ApiResponse<List<Orders>> response = new ApiResponse<>("orders fetched successfully", 200,
                orderService.getAllOrders());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Orders>> getOrderById(
            @PathVariable long id)
    {
        ApiResponse<Orders> response = new ApiResponse<>("order fetched successfully", 200, orderService.getOrderById(id));

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Orders>> updateOrder(
            @PathVariable Long id,
            @RequestBody Orders order)
    {
        ApiResponse<Orders> response = new ApiResponse<>("order updated successfully", 200, orderService.updateOrder(id, order));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteOrder(
            @PathVariable Long id)
{
    orderService.deleteOrder(id);
    ApiResponse<String> response = new ApiResponse<>("order deleted successfully", 200, null);
    return ResponseEntity.ok(response);
}

}
