package com.example.productCRUD.controller;

import com.example.productCRUD.model.Product;
import com.example.productCRUD.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }
    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id)
    {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product)
    {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id)
    {
        boolean deleted = productService.deleteProduct(id);

        if(deleted)
        {
            return ResponseEntity.ok("product deletd successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("product notfound with id: " + id);
        }
    }

}
