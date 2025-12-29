package com.example.SwaggerCRUD.service;

import com.example.SwaggerCRUD.entity.Product;
import com.example.SwaggerCRUD.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product update(Long id, Product product) {
        Product existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setCategory(product.getCategory());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id)
    {
        repository.deleteById(id);
    }
}
