package com.finance.tracker.service;

import com.finance.tracker.repository.TransactionRepository;
import com.finance.tracker.model.Transaction;
import com.finance.tracker.model.TransactionType;
import java.util.List;

public class TransactionService {

    private TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public void addTransaction(Transaction transaction) {
        if (transaction.getValue() <= 0) {
            throw new IllegalArgumentException("O valor da transação deve ser maior que zero.");
        }
        for (Transaction existing : getAllTransactions()) {
            if (existing.getId() == transaction.getId()) {
                throw new IllegalArgumentException("Já existe uma transação com esse ID cadastrada");
            }
        }
        repository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public double calculateBalance() {
        return calculateAllRevenue() - calculateAllExpenses();
    }

    public double calculateAllExpenses() {
        double balance = 0.00;
        for (Transaction transaction : repository.findAll()) {
            if (transaction.getType() == TransactionType.EXPENSES) {
                balance += transaction.getValue();
            }
        }
        return balance;
    }

    public double calculateAllRevenue() {
        double balance = 0.00;
        for (Transaction transaction : repository.findAll()) {
            if (transaction.getType() == TransactionType.REVENUE) {
                balance += transaction.getValue();
            }
        }
        return balance;
    }

    public void updateTransaction(Transaction transaction) {
        if (transaction.getValue() <= 0) {
            throw new IllegalArgumentException("O valor da transação deve ser maior que zero.");
        }

        boolean exists = false;

        for (Transaction existing : getAllTransactions()) {
            if (transaction.getId() == existing.getId()) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            throw new IllegalArgumentException("A transação não existe ou não pode ser encontrada");
        }
        repository.update(transaction);
    }

    public void deleteTransaction(int id) {
        boolean exists = false;

        for (Transaction existing : getAllTransactions()) {
            if (id == existing.getId()) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            throw new IllegalArgumentException("A transação indicada não existe");
        }

        repository.deleteById(id);
    }

}
