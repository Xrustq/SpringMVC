package com.epam.shop.less.shop.database;

import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.exeption.NotFoundUserException;

public interface UserDatabase {

    void addUser(User user);

    User findByEmail(String email);
}
