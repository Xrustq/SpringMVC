package com.epam.shop.less.shop.controller;

import com.epam.shop.less.shop.database.ProductDatabase;
import com.epam.shop.less.shop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Admin {

    @Autowired
    ProductDatabase productDatabase;

    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("list", productDatabase.getProducts());
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @PostMapping("admin/add")
    public String addProduct(@ModelAttribute("product") Product product) {

        productDatabase.createProduct(product);

        return "redirect:/admin";
    }

    @RequestMapping("admin/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productDatabase.deleteProduct(id);
        return "redirect:/admin";
    }

    @RequestMapping("admin/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") int id, @ModelAttribute("product") Product product, ModelAndView modelAndView) {
        modelAndView.addObject("product", productDatabase.getProductById(id));
        modelAndView.addObject("list", productDatabase.getProducts());
        productDatabase.updateProduct(product);
        modelAndView.setViewName("admin");
        return modelAndView;
    }
}
