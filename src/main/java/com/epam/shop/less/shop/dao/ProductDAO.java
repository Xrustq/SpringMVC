package com.epam.shop.less.shop.dao;

import com.epam.shop.less.shop.entity.Product;

import java.util.List;

public interface ProductDAO {

    Product getProductById(int productId);

    List<Product> getProducts();

    List<Product> getProductsByName(String name);

    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);
}
