package com.epam.shop.less.shop.session;

import com.epam.shop.less.shop.entity.User;

public interface SessionManager {
    User getUser();
    void setUser(User user);
}
