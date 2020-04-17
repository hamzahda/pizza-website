package com.product.service;

import java.util.List;

import com.product.entity.Product;

public interface IProductService {
    public void createProduct(Product Product);
    public List<Product> getProduct();
    public Product findById(long id);
    public Product update(Product Product);
    public void deleteProductById(long id);
}