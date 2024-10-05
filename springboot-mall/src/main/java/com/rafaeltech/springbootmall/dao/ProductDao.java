package com.rafaeltech.springbootmall.dao;

import com.rafaeltech.springbootmall.constant.ProductCategory;
import com.rafaeltech.springbootmall.dto.ProductQueryParams;
import com.rafaeltech.springbootmall.dto.ProductRequest;
import com.rafaeltech.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductQueryParams params);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(int productId, ProductRequest productRequest);

    void deleteProduct(int productId);

    Integer countProduct(ProductQueryParams params);
}
