package com.epam.shop.less.shop.dao;

import com.epam.shop.less.shop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {

//    List<Category> getCategory();

//    void createCategory(Category category);
}
