package com.epam.shop.less.shop.controller;

//import com.epam.shop.less.shop.database.SearchDatabase;
import com.epam.shop.less.shop.entity.Search;
import com.epam.shop.less.shop.service.CategoryService;
import com.epam.shop.less.shop.session.UserSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {

    @Autowired
    UserSessionManager userSessionManager;

    @Autowired
    CategoryService categoryService;

//    @Autowired
//    SearchDatabase searchDatabase;

    @GetMapping("/main")
    public ModelAndView main(ModelAndView modelAndView) {
        modelAndView.addObject("user", userSessionManager.getUser());
        modelAndView.addObject("list",categoryService.getCategory());
        modelAndView.addObject("searchString", new Search());
        modelAndView.setViewName("main");

        return modelAndView;
    }

    @PostMapping("/main")
    public ModelAndView search(@ModelAttribute("searchString") Search searchString, ModelAndView modelAndView) {
//        modelAndView.addObject("search", searchDatabase.getProductByName(searchString.getName()));
        modelAndView.addObject("user", userSessionManager.getUser());
        modelAndView.addObject("list",categoryService.getCategory());
        modelAndView.setViewName("main");

        return modelAndView;
    }
}
