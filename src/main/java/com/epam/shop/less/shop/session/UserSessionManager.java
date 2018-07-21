package com.epam.shop.less.shop.session;

import com.epam.shop.less.shop.entity.User;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UserSessionManager{

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}