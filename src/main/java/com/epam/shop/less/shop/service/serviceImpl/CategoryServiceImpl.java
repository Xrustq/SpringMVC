package com.epam.shop.less.shop.service.serviceImpl;

import com.epam.shop.less.shop.dao.CategoryDAO;
import com.epam.shop.less.shop.entity.Category;
import com.epam.shop.less.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public List<Category> getCategory() {
        return categoryDAO.findAll();
    }

}
