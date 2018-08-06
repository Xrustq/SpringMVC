package com.epam.shop.less.shop.controller;

import com.epam.shop.less.shop.entity.Search;
import com.epam.shop.less.shop.service.CategoryService;
import com.epam.shop.less.shop.service.ProductService;
import com.epam.shop.less.shop.session.UserSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {

    @Autowired
    UserSessionManager userSessionManager;

    @Autowired
    CategoryService categoryService;

//    @Autowired
//    BasketService basketService;

    @Autowired
    ProductService productService;

    @GetMapping("/main")
    public ModelAndView main(ModelAndView modelAndView) {
        modelAndView.addObject("user", userSessionManager.getUser());
        modelAndView.addObject("list", categoryService.getCategory());
//        modelAndView.addObject("basket", basketService.getProductsFromBasket());
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
//    @GetMapping("/main/add/{id}")
//    public ModelAndView addToBasketById(@PathVariable Long id, ModelAndView modelAndView) {
//
//        basketService.addProductToBasket(productService.getProductById(id));
//
//        modelAndView.setViewName("redirect:/main");
//        return modelAndView;
//    }
//
//    @GetMapping("/main/delete/{id}")
//    public ModelAndView deleteFromBasketById(@PathVariable Long id, ModelAndView modelAndView) {
//
//        basketService.deleteProductFromBasketById(id);
//        modelAndView.setViewName("redirect:/main");
//        return modelAndView;
//    }

}
