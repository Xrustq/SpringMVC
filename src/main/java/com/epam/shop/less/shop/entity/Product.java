package com.epam.shop.less.shop.entity;

import java.util.Objects;

public class Product {

    private int id;
    private String name;
    private int price;
    private String img;
    private int category;

    public Product() {
    }

    public Product(int id, String name, int price, String img, int category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                category == product.category &&
                Objects.equals(name, product.name) &&
                Objects.equals(img, product.img);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, img, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                ", category=" + category +
                '}';
    }
}
