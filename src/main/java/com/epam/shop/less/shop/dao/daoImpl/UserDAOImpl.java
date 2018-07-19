package com.epam.shop.less.shop.dao.daoImpl;

import com.epam.shop.less.shop.dao.UserDAO;
import com.epam.shop.less.shop.database.UserDatabase;
import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.exeption.NotFoundUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    UserDatabase userDatabase;

    @Override
    public User findByEmail(String email) {
        return userDatabase.findByEmail(email);
    }

    @Override
    public void createUser(User user) {
        userDatabase.addUser(user);
    }
}
