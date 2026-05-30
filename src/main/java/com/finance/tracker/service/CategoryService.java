package com.finance.tracker.service;

import java.util.List;

import com.finance.tracker.model.Category;
import com.finance.tracker.repository.CategoryRepository;

public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        for (Category existing : getAllCategory()) {
            if (existing.getId() == category.getId()) {
                throw new IllegalArgumentException("Ja existe uma categoria registrada com ID: " + existing.getId());
            } else if (existing.getName().equalsIgnoreCase(category.getName())) {
                throw new IllegalArgumentException("Ja existe uma categoria com esse nome: " + existing.getName());
            }
        }
        categoryRepository.saveCategory(category);
    }

}
