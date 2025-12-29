package com.example.ExceptionHandling._2.service;

import com.example.ExceptionHandling._2.entity.Product;
import com.example.ExceptionHandling._2.exception.ProductNotFoundException;
import com.example.ExceptionHandling._2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product)
    {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public Product getProductById(Long id)
    {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("product not found with id:" + id));
    }

    public Product updateProduct(long id, Product product)
    {
        Product existing = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("product not found with id:" + id));
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());

        return productRepository.save(existing);
    }

    public void deleteProduct(Long id)
    {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("product not found with id: " +id));
                productRepository.delete(product);
    }
}
