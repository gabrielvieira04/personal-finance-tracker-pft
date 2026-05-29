package com.finance.tracker.repository;

import java.util.ArrayList;
import java.util.List;

import com.finance.tracker.model.Category;

public class InMemoryCategoryRepository implements CategoryRepository {

    private List<Category> categoryList = new ArrayList<>();

    public void saveCategory(Category category) {
        categoryList.add(category);
    }

    public List<Category> findAll() {
        return categoryList;
    }

}
