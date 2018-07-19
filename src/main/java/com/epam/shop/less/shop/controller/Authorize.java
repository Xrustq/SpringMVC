package com.epam.shop.less.shop.controller;

import com.epam.shop.less.shop.entity.LoginUser;
import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.exeption.NotFoundUserException;
import com.epam.shop.less.shop.service.UserService;
import com.epam.shop.less.shop.session.UserSessionManager;
import com.epam.shop.less.shop.validator.AuthorizeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Authorize {

    @Autowired
    UserService userService;

    @Autowired
    AuthorizeValidator authorizeValidator;

    @Autowired
    UserSessionManager userSessionManager;

    @GetMapping("/authorize")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userForm", new LoginUser());
        modelAndView.setViewName("authorize");
        return modelAndView;
    }

    @PostMapping("/authorize")
    public String login(@ModelAttribute("userForm") LoginUser userForm, BindingResult bindingResult) {

        LoginUser loginUser = new LoginUser();
        loginUser.setEmail(userForm.getEmail());
        loginUser.setPassword(userForm.getPassword());

        authorizeValidator.validate(loginUser, bindingResult);

        if (bindingResult.hasErrors()) {
            return "authorize";
        }

        User user = userService.findByEmail(userForm.getEmail());

        userSessionManager.setUser(user);

        return "redirect:/main";
    }


}
