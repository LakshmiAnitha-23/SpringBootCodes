package com.example.SwaggerCRUD.controller;

import com.example.SwaggerCRUD.entity.Product;
import com.example.SwaggerCRUD.responses.ApiResponse;
import com.example.SwaggerCRUD.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name= "ProductApi", description = "CRUD using swagger with ApiResponse")
public class ProductController
{
    private final ProductService service;

    public ProductController(ProductService service)
    {
        this.service = service;
    }

    @Operation(summary = "create product")
    @PostMapping
    public ApiResponse<Product> create(@RequestBody Product product)
    {
        return new ApiResponse<>("product created", service.save(product));
    }

    @Operation(summary = "Get product by ID")
    @GetMapping("/{id}")
    public ApiResponse<Product> getById(@PathVariable Long id)
    {
        return new ApiResponse<>("product Found", service.getById(id));
    }

    @Operation(summary = "Get All Products")
    @GetMapping
    public ApiResponse<List<Product>> getAll()
    {
        return new ApiResponse<>("product List", service.getAll());
    }

    @Operation(summary = "update product")
    @PutMapping("/{id}")
    public ApiResponse<Product> update(@PathVariable Long id,
                                       @RequestBody Product product)
    {
        return new ApiResponse<>("product updated", service.update(id, product));
    }

    @Operation(summary = "Delete product")
    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id)
    {
        service.delete(id);
        return new ApiResponse<>("product Deleted", "Deleted Successfully");
    }

}
