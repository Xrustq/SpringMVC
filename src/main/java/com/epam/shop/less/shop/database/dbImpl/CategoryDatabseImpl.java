package com.epam.shop.less.shop.database.dbImpl;

import com.epam.shop.less.shop.database.CategoryDatabse;
import com.epam.shop.less.shop.entity.Category;
import com.epam.shop.less.shop.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDatabseImpl implements CategoryDatabse {

    private ArrayList<Category> categoriesList = new ArrayList<>();

    @Override
    public List<Category> getCategories() {
        return categoriesList;
    }

    @Override
    public void createCategory(Category category) {
        categoriesList.add(category);
    }
}
