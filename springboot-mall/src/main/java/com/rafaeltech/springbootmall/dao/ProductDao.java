package com.rafaeltech.springbootmall.dao;

import com.rafaeltech.springbootmall.dto.ProductRequest;
import com.rafaeltech.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
