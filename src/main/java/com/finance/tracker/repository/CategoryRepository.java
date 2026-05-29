package com.finance.tracker.repository;

import com.finance.tracker.model.Category;
import java.util.List;

public interface CategoryRepository {

    void saveCategory(Category category);

    List<Category> findAll();

}
