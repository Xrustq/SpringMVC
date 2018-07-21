package com.epam.shop.less.shop.interceptor;

import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.session.UserSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GuestInterceptor implements HandlerInterceptor {

    @Autowired
    UserSessionManager userSessionManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = userSessionManager.getUser();
        if (user == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
