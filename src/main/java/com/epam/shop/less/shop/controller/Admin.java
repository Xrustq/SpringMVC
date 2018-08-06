package com.epam.shop.less.shop.controller;

import com.epam.shop.less.shop.entity.Product;
import com.epam.shop.less.shop.service.CategoryService;
import com.epam.shop.less.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Admin {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("list", categoryService.getCategory());
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @PostMapping("admin/add")
    public String addProduct(@ModelAttribute("product") Product product) {
//        categoryService.getCategory().get(product.getCategory().getId()).getProductDatabase().createProduct(product);
        productService.createProduct(product);

        return "redirect:/admin";
    }

    @RequestMapping("admin/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
//        categoryService.getCategory().get(category).getProductDatabase().deleteProduct(id);
        productService.deleteProduct(id);
        return "redirect:/admin";
    }

    @RequestMapping("admin/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") Long id, ModelAndView modelAndView) {
        modelAndView.addObject("product", productService.getProductById(id));
        modelAndView.addObject("list", categoryService.getCategory());
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @PostMapping("admin/edit")
    public ModelAndView edit(@ModelAttribute("product") Product product, ModelAndView modelAndView) {
        productService.updateProduct(product);
        modelAndView.setViewName("admin");
        return modelAndView;
    }

}
