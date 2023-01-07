package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Category;

import java.util.ArrayList;
public interface CategoryDataAccess {
    ArrayList<Category> getAllCategories();
}