//package com.epam.shop.less.shop.dao;
//
//import com.epam.shop.less.shop.entity.Basket;
//import com.epam.shop.less.shop.entity.Product;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface BasketDAO extends JpaRepository<Basket, Long> {
//
//    @Query(value = "SELECT * FROM basket", nativeQuery = true)
//    List<Product> getProductsFromBasket();
//
//    void deleteProductFromBasketById(Long id);
//
//    @Query(value = "INSERT INTO basket (basket_id) VALUES (?1)", nativeQuery = true)
//    void createBasketByUserId(Long id);
//}
