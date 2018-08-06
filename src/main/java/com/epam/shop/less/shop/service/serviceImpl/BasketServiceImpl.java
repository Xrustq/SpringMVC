//package com.epam.shop.less.shop.service.serviceImpl;
//
//import com.epam.shop.less.shop.dao.BasketDAO;
//import com.epam.shop.less.shop.entity.Product;
//import com.epam.shop.less.shop.service.BasketService;
//import com.epam.shop.less.shop.session.UserSessionManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BasketServiceImpl implements BasketService {
//
//    @Autowired
//    BasketDAO basketDAO;
//
//    @Autowired
//    UserSessionManager userSessionManager;
//
//    @Override
//    public void addProductToBasket(Product product) {
//        basketDAO.getOne(userSessionManager.getUser().getId()).setProduct(product);
//    }
//
//    @Override
//    public List<Product> getProductsFromBasket() {
//        return basketDAO.getProductsFromBasket();
//    }
//
//    @Override
//    public void deleteProductFromBasketById(Long id){
//        basketDAO.deleteProductFromBasketById(id);
//    }
//
//    @Override
//    public void createBasketByUserId(Long id) {
//        basketDAO.createBasketByUserId(id);
//    }
//
//
//}
