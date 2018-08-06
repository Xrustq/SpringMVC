package com.epam.shop.less.shop.service;

import com.epam.shop.less.shop.entity.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long productId);

    List<Product> getProducts();

    Product getProductsByName(String name);

    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long productId);
}
