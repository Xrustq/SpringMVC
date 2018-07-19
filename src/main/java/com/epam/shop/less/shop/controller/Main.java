package com.epam.shop.less.shop.controller;

import com.epam.shop.less.shop.session.UserSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {

    @Autowired
    UserSessionManager userSessionManager;

    @GetMapping({"/", "/main"})
    public ModelAndView main(ModelAndView modelAndView) {
        modelAndView.addObject("user", userSessionManager.getUser());
        modelAndView.setViewName("main");

        return modelAndView;
    }
}