package com.epam.shop.less.shop.service;

import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.exeption.NotFoundUserException;

public interface UserService {

    void save(User user);

    User getUserById(Long id) ;

    User getUserByEmail(String email);
}
