package com.finance.tracker.repository;

import java.util.ArrayList;
import java.util.List;

import com.finance.tracker.model.Category;

public class InMemoryCategoryRepository implements CategoryRepository {

    private List<Category> categoryList = new ArrayList<>();

    @Override
    public void saveCategory(Category category) {
        categoryList.add(category);

    }

    @Override
    public List<Category> findAll() {
        return categoryList;
    }

    @Override
    public void update(Category category) {
        for (int i = 0; i <= categoryList.size(); i++){
            if (categoryList.get(i).getId() == category.getId()) {
                categoryList.set(i, category);
            }
        }

    }

    @Override
    public void deleteById(int id) {
        categoryList.removeIf(c -> c.getId() == id);
    }

}
