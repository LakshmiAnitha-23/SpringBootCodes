package com.example.ResponseEntity._4.controller;

import com.example.ResponseEntity._4.entity.SwiggyOrder;
import com.example.ResponseEntity._4.responses.ApiResponse;
import com.example.ResponseEntity._4.service.SwiggyOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/swiggy")
public class SwiggyOrderController
{
    private final SwiggyOrderService service;

    public SwiggyOrderController(SwiggyOrderService service)
    {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<SwiggyOrder>> createOrder(
         @RequestBody SwiggyOrder order)
    {
        ApiResponse<SwiggyOrder> response = new ApiResponse<>(
                "order placed successfully",
                LocalDateTime.now(),
                service.createOrder(order),
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<SwiggyOrder>>> getAllOrders()
    {
        ApiResponse<List<SwiggyOrder>> response =
                new ApiResponse<>(
                        "All orders fetched",
                        LocalDateTime.now(),
                        service.getAllOrders(),
                        HttpStatus.OK.value()
                );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SwiggyOrder>> getOrderById(
            @PathVariable Long id)
    {
        ApiResponse<SwiggyOrder> response =
                new ApiResponse<>(
                        "order found",
                        LocalDateTime.now(),
                        service.getOrderById(id),
                        HttpStatus.OK.value()
                );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<SwiggyOrder>> updateOrder(
            @PathVariable long id,
            @RequestBody SwiggyOrder order)
    {
        ApiResponse<SwiggyOrder> response =
                new ApiResponse<>(
                        "order updated",
                        LocalDateTime.now(),
                        service.updateOrder(id, order),
                        HttpStatus.OK.value()
                );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteOrder(
            @PathVariable Long id)
    {
        service.deleteOrder(id);

        ApiResponse<String> response =
                new ApiResponse<>(
                        "order deleted",
                        LocalDateTime.now(),
                        "Deleted order id: " + id,
                        HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }
}
