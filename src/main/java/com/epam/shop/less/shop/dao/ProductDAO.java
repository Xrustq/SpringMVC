package com.epam.shop.less.shop.dao;

import com.epam.shop.less.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    Product getProductById(Long productId);

    List<Product> getProductByName(String name);
}
