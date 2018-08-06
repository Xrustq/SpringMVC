package com.epam.shop.less.shop.dao;

import com.epam.shop.less.shop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {
}
