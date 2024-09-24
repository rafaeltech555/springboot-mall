package com.rafaeltech.springbootmall.controller;

import com.rafaeltech.springbootmall.dto.ProductRequest;
import com.rafaeltech.springbootmall.model.Product;
import com.rafaeltech.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId) {
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {

        Integer productId = productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable int productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {

        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        productService.updateProduct(productId, productRequest);

        return  ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(productId));
    }
}
