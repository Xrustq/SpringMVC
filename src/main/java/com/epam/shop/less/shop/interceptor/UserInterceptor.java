package com.epam.shop.less.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.shop.less.shop.entity.Role;
import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.session.UserSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    UserSessionManager userSessionManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = userSessionManager.getUser();
        if (Objects.isNull(user) || !user.getRole().equals(Role.USER)) {
            response.sendRedirect("/login");
            return false;
        }
//        request.setAttribute("user", user);
        return true;
    }
}
