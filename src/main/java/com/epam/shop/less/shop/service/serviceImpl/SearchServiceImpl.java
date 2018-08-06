package com.epam.shop.less.shop.service.serviceImpl;

import com.epam.shop.less.shop.entity.Product;
import com.epam.shop.less.shop.service.ProductService;
import com.epam.shop.less.shop.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    ProductService productService;

    @Override
    public Product findProducts(String name) {
        List<Product> products = productService.getProducts();
        Product foundProduct = null;
        for (int i = 0; i < products.size(); i++) {
           if (products.get(i).getName().equals(name)) {
                foundProduct = products.get(i);
           }
        }
        return foundProduct;
    }
}
