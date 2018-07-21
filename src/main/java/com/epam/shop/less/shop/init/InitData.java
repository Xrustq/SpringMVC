package com.epam.shop.less.shop.init;

import com.epam.shop.less.shop.database.ProductDatabase;
import com.epam.shop.less.shop.database.UserDatabase;
import com.epam.shop.less.shop.entity.Product;
import com.epam.shop.less.shop.entity.Role;
import com.epam.shop.less.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class InitData {

    @Autowired
    UserDatabase userDatabase;

    @Autowired
    ProductDatabase productDatabase;

    @PostConstruct
    public void init() {

        User admin = new User();
        admin.setEmail("admin@mail.ru");
        admin.setPassword("123123123");
        admin.setConfirmPassword("123123123");
        admin.setFirstName("Rustam");
        admin.setLastName("admin");
        admin.setRole(Role.ADMIN);
        userDatabase.addUser(admin);


        Product product = new Product();
        product.setId(20);
        product.setName("qweqwe");
        product.setPrice(333);
        product.setImg("img/square.png");


        Product product2 = new Product();
        product2.setId(21);
        product2.setName("zxczxczx");
        product2.setPrice(222);
        product2.setImg("img/square.png");

        productDatabase.createProduct(product);
        productDatabase.createProduct(product2);

    }
}
