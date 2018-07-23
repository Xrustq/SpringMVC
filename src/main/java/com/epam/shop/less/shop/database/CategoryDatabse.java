package com.epam.shop.less.shop.database;

import com.epam.shop.less.shop.entity.Category;
import com.epam.shop.less.shop.entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface CategoryDatabse {

    List<Category> getCategories();

    void createCategory(Category category);
}
