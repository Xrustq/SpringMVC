package com.epam.shop.less.shop.service.serviceImpl;

import com.epam.shop.less.shop.dao.UserDAO;
import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.exeption.NotFoundUserException;
import com.epam.shop.less.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public void save(User user) {
        userDAO.createUser(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }
}
