package com.epam.shop.less.shop.database.dbImpl;

import com.epam.shop.less.shop.database.SearchDatabase;
import com.epam.shop.less.shop.entity.Product;
import com.epam.shop.less.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SearchDatabaseImpl implements SearchDatabase {

    @Autowired
    CategoryService categoryService;

    @Override
    public Product getProductByName(String name) {
        for (int i = 0; i < categoryService.getCategories().size(); i++) {
            for (int j = 0; j < categoryService.getCategories().get(i).getProductDatabase().getProducts().size(); j++) {
                if (categoryService.getCategories().get(i).getProductDatabase().getProducts().get(j).getName().equals(name)) {
                    return categoryService.getCategories().get(i).getProductDatabase().getProducts().get(j);
                }
            }
        }
        return null;
    }
}
