package com.epam.shop.less.shop.database;

import com.epam.shop.less.shop.entity.Product;

import java.util.List;

public interface ProductDatabase {

    Product getProductById(int productId);

    List<Product> getProducts();

    List<Product> getProductsByName(String name);

    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);
}
