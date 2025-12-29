package com.example.productCRUD.service;

import com.example.productCRUD.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    private List<Product> productList = new ArrayList<>();

    public Product addProduct(Product product)
    {
        productList.add(product);
        return product;
    }

    public List<Product> getAllProducts(){
        return productList;
    }

    public Product getProductById(Long id)
    {
        for(Product product : productList)
        {
            if(product.getId().equals(id))
            {
                return product;
            }
        }
        return null;
    }

    public Product updateProduct(Long id, Product updatedProduct)
    {
        for(Product product : productList)
        {
            if(product.getId().equals(id))
            {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                return product;
            }
        }
        return null;
    }
    public boolean deleteProduct(Long id)
    {
        return productList.removeIf(product ->
                product.getId() != null && product.getId().equals(id));
    }
}
