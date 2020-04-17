package com.product.service;

import java.util.List;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(final Product Product) {
        productRepository.save(Product);
    }

    public List<Product> getProduct() {
        return (List<Product>) productRepository.findAll();
    }

    public Product findById(final long id) {
        return productRepository.findById(id).orElseThrow(() -> 
        new RuntimeException("Product is not found"));
    }

    public Product update(final Product Product) {
        return productRepository.save(Product);
    }

    public void deleteProductById(final long id) {
        productRepository.deleteById(id);
    }

}