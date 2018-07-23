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

import javax.servlet.http.HttpSession;

@Controller
public class Login {

    @Autowired
    UserService userService;

    @Autowired
    AuthorizeValidator authorizeValidator;

    @Autowired
    UserSessionManager userSessionManager;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userForm", new LoginUser());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("userForm") LoginUser userForm, BindingResult bindingResult) {

        authorizeValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "login";
        }

        User user = userService.findByEmail(userForm.getEmail());

        userSessionManager.setUser(user);

        return "redirect:/main";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @ExceptionHandler(NotFoundUserException.class)
    public String handleUserNotFoundException(Model model) {
        return "login";
    }


}
