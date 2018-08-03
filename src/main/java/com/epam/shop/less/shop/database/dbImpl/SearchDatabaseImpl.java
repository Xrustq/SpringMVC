//package com.epam.shop.less.shop.database.dbImpl;
//
//import com.epam.shop.less.shop.database.SearchDatabase;
//import com.epam.shop.less.shop.entity.Product;
//import com.epam.shop.less.shop.service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public class SearchDatabaseImpl implements SearchDatabase {
//
//    @Autowired
//    CategoryService categoryService;
//
//    @Override
//    public Product getProductByName(String name) {
//        for (int i = 0; i < categoryService.getCategory().size(); i++) {
//            for (int j = 0; j < categoryService.getCategory().get(i).getProductDatabase().getProduct().size(); j++) {
//                if (categoryService.getCategory().get(i).getProductDatabase().getProduct().get(j).getName().equals(name)) {
//                    return categoryService.getCategory().get(i).getProductDatabase().getProduct().get(j);
//                }
//            }
//        }
//        return null;
//    }
//}
