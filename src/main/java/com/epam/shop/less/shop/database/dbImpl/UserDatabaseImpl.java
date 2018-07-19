package com.epam.shop.less.shop.database.dbImpl;

import com.epam.shop.less.shop.database.UserDatabase;
import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.exeption.NotFoundUserException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserDatabaseImpl implements UserDatabase {

    private ArrayList<User> userDatabase = new ArrayList<>();

    public void addUser(User user) {
        userDatabase.add(user);
        System.out.println(user.toString());
    }

    public User findByEmail(String email) {
        User user = null;
        for (int i = 0; i < userDatabase.size(); i++) {
            System.out.println(userDatabase.get(i).toString());
            if (email.equals(userDatabase.get(i).getEmail()))
                user = userDatabase.get(i);
        }
        if (user == null)
            try {
                throw new NotFoundUserException();
            } catch (NotFoundUserException e) {
                e.printStackTrace();
            }
        return user;
    }
}