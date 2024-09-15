package com.rafaeltech.springbootmall.dao.impl;

import com.rafaeltech.springbootmall.dao.ProductDao;
import com.rafaeltech.springbootmall.model.Product;
import com.rafaeltech.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, created_date, last_modified_date FROM product WHERE product_id = :productId";

        Map<String, Object> params = new HashMap<>();
        params.put("productId", productId);

        try {
            List<Product> productList = namedParameterJdbcTemplate.query(sql, params, new ProductRowMapper());
            if (!productList.isEmpty()) {
                return productList.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching product", e);
        }
    }
}
