package com.epam.shop.less.shop.entity;

import com.epam.shop.less.shop.database.ProductDatabase;

import java.util.List;
import java.util.Objects;

public class Category {

    private String name;
    private ProductDatabase products;

    public Category(String name, ProductDatabase products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products.getProducts();
    }

    public ProductDatabase getProductDatabase() {
        return products;
    }

    public void setProducts(ProductDatabase products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, products);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
