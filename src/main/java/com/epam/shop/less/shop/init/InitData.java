package com.epam.shop.less.shop.init;


import com.epam.shop.less.shop.database.CategoryDatabse;
import com.epam.shop.less.shop.database.ProductDatabase;
import com.epam.shop.less.shop.database.UserDatabase;
import com.epam.shop.less.shop.entity.Category;
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
    CategoryDatabse categoryDatabse;

    @Autowired
    ProductDatabase productDatabase;

    @Autowired
    ProductDatabase productDatabase2;

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

        for (int i = 1; i <= 6; i++) {
            productDatabase.createProduct(new Product(i, "Product" + i, i, "img/square.png", 0));
        }

        for (int i = 13; i <= 20; i++) {
            productDatabase2.createProduct(new Product(i, "Product" + i, i, "img/square.png", 1));
        }


        categoryDatabse.createCategory(new Category("Категория товаров 1", productDatabase));
        categoryDatabse.createCategory(new Category("Категория товаров 2", productDatabase2));


    }
}

