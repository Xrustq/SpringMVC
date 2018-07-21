package com.epam.shop.less.shop.service.serviceImpl;

import com.epam.shop.less.shop.dao.ProductDAO;
import com.epam.shop.less.shop.entity.Product;
import com.epam.shop.less.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Override
    public Product getProductById(int productId) {
        return productDAO.getProductById(productId);
    }

    @Override
    public List<Product> getProducts() {
        return productDAO.getProducts();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productDAO.getProductsByName(name);
    }

    @Override
    public void createProduct(Product product) {
        productDAO.createProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productDAO.deleteProduct(productId);
    }
}
