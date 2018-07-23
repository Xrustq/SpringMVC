package com.epam.shop.less.shop.dao;

import com.epam.shop.less.shop.entity.Category;

import java.util.List;

public interface CategoryDAO  {

    List<Category> getCategories();

    void createCategory(Category category);
}
