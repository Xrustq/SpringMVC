package com.epam.shop.less.shop.dao;

import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.exeption.NotFoundUserException;

public interface UserDAO {
    User findByEmail(String email);

    void createUser(User user);
}
