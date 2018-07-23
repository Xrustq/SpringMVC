package com.epam.shop.less.shop.controller;

import com.epam.shop.less.shop.entity.Product;
import com.epam.shop.less.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Admin {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("list", categoryService.getCategories());
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @PostMapping("admin/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        categoryService.getCategories().get(product.getCategory()).getProductDatabase().createProduct(product);

        return "redirect:/admin";
    }

    @RequestMapping("admin/delete/{id}/{category}")
    public String deleteProduct(@PathVariable("id") int id, @PathVariable("category") int category) {

        categoryService.getCategories().get(category).getProductDatabase().deleteProduct(id);
        return "redirect:/admin";
    }

    @RequestMapping("admin/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") int id, @ModelAttribute("product") Product product, ModelAndView modelAndView) {
        modelAndView.addObject("product", categoryService.getCategories().get(product.getCategory()).getProductDatabase().getProductById(id));
        modelAndView.addObject("list", categoryService.getCategories());
        categoryService.getCategories().get(product.getCategory()).getProductDatabase().updateProduct(product);
        modelAndView.setViewName("admin");
        return modelAndView;
    }
}
