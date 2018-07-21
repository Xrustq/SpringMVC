package com.epam.shop.less.shop.interceptor;

import java.time.LocalTime;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.shop.less.shop.entity.Role;
import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.session.UserSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    UserSessionManager userSessionManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = userSessionManager.getUser();
        if (Objects.isNull(user) || !user.getRole().equals(Role.ADMIN)) {
            response.sendRedirect("/");
            return false;
        }

        LocalTime time = LocalTime.now();
        int hrs = time.getHour();
        if (hrs >= 0 && hrs <= 12) {
            request.setAttribute("greeting", "Доброе утро! " + user.getFirstName());
        } else if (hrs > 12 && hrs <= 17) {
            request.setAttribute("greeting", "Добрый день! " + user.getFirstName());
        } else {
            request.setAttribute("greeting", "Добрый вечер! " + user.getFirstName());
        }
//        request.setAttribute("user", user);
        return true;
    }



}
