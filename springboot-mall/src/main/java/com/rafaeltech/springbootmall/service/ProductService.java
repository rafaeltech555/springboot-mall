package com.rafaeltech.springbootmall.service;

import com.rafaeltech.springbootmall.dto.ProductRequest;
import com.rafaeltech.springbootmall.model.Product;
import jakarta.validation.Valid;

public interface ProductService {
    Product getProductById(int productId);

    Integer createProduct(@Valid ProductRequest productRequest);

    void updateProduct(int productId, @Valid ProductRequest productRequest);
}
