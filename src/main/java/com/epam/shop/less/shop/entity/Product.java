package com.epam.shop.less.shop.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @JoinColumn(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "img")
    private String img;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

//    @ManyToOne
//    @JoinColumn(name = "manufacturer_id")
//    private Manufacturer manufacturer;

//    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
//    private Set<Basket> basketSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//    public Manufacturer getManufacturer() {
//        return manufacturer;
//    }
//
//    public void setManufacturer(Manufacturer manufacturer) {
//        this.manufacturer = manufacturer;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(img, product.img) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, img, category);
    }
}
