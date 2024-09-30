package com.rafaeltech.springbootmall.service;

import com.rafaeltech.springbootmall.constant.ProductCategory;
import com.rafaeltech.springbootmall.dto.ProductQueryParams;
import com.rafaeltech.springbootmall.dto.ProductRequest;
import com.rafaeltech.springbootmall.model.Product;
import jakarta.validation.Valid;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductQueryParams params);

    Product getProductById(int productId);

    Integer createProduct(@Valid ProductRequest productRequest);

    void updateProduct(int productId, @Valid ProductRequest productRequest);

    void deleteProduct(int productId);

}
