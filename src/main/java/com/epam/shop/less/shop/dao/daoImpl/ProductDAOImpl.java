//package com.epam.shop.less.shop.dao.daoImpl;
//
//import com.epam.shop.less.shop.dao.ProductDAO;
//import com.epam.shop.less.shop.database.ProductDatabase;
//import com.epam.shop.less.shop.entity.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class ProductDAOImpl implements ProductDAO {
//
//    @Autowired
//    ProductDatabase productDatabase;
//
//    @Override
//    public Product getProductById(int productId) {
//        return productDatabase.getProductById(productId);
//    }
//
//    @Override
//    public List<Product> getProduct() {
//        return productDatabase.getProducts();
//    }
//
//    @Override
//    public List<Product> getProductByName(String name) {
//        return productDatabase.getProductsByName(name);
//    }
//
//    @Override
//    public void createProduct(Product product) {
//        productDatabase.createProduct(product);
//    }
//
//    @Override
//    public void updateProduct(Product product) {
//        productDatabase.updateProduct(product);
//    }
//
//    @Override
//    public void deleteProduct(int productId) {
//        productDatabase.deleteProduct(productId);
//    }
//}
