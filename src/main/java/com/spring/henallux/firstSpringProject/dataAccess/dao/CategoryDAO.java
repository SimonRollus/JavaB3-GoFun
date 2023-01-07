package com.spring.henallux.firstSpringProject.dataAccess.dao;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryDAO implements CategoryDataAccess {

    private CategoryRepository categoryRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository, ProviderConverter providerConverter){
        this.categoryRepository = categoryRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Category> getAllCategories(){
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        ArrayList<Category> categories = new ArrayList<>();
        for(CategoryEntity entity : categoryEntities){
            Category category = providerConverter.categoryEntityToCategoryModel(entity);
            categories.add(category);
        }
        return categories;
    }
}
