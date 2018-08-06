package com.epam.shop.less.shop.service;

import com.epam.shop.less.shop.entity.Product;

import java.util.List;

public interface SearchService {

    Product findProducts(String name);
}
