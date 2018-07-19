package com.epam.shop.less.shop.controller;

import com.epam.shop.less.shop.entity.User;
import com.epam.shop.less.shop.service.UserService;
import com.epam.shop.less.shop.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Registration {

    @Autowired
    UserValidator userValidator;

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userForm", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        return "redirect:/authorize";
    }
}