package com.finance.tracker.service;

import java.util.List;

import com.finance.tracker.model.Category;
import com.finance.tracker.model.Transaction;
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

    public void updateCategory(Category category) {
        boolean exists = false;

        for (Category existing : getAllCategory()) {
            if (category.getId() == existing.getId()) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            throw new IllegalArgumentException("Categoria não encontrada");
        }

        for (Category existing : getAllCategory()) {
            if (existing.getId() != category.getId() && existing.getName().equalsIgnoreCase(category.getName())) {
                throw new IllegalArgumentException("Já existe uma categoria com esse nome");
            }
        }

        categoryRepository.update(category);

    }

    public void deleteCategory(int id, List<Transaction> transactions) {
        boolean exists = false;

        for (Category existing : getAllCategory()) {
            if (id == existing.getId()) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            throw new IllegalArgumentException("Categoria não encontrada");
        }

        for (Transaction t : transactions) {
            if (t.getTransactionCategory() != null && t.getTransactionCategory().getId() == id) {
                throw new IllegalArgumentException(
                        "Não é possivel deletar uma categoria que esta vinculada a uma transação.");
            }
        }

        categoryRepository.deleteById(id);

    }

}
