package com.epam.shop.less.shop.entity;

import java.util.Map;

public class Category {

    private int id;
    private Map<Integer, Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }
}
