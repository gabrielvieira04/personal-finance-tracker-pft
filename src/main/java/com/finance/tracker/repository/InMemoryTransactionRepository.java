package com.finance.tracker.repository;

import com.finance.tracker.model.Transaction;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTransactionRepository implements TransactionRepository {

    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void save(Transaction transaction) {
        transactions.add(transaction);

    }

    @Override
    public List<Transaction> findAll() {
        return transactions;
    }

    @Override
    public void update(Transaction transaction) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId() == transaction.getId()) {
                transactions.set(i, transaction);
            }
        }
    }

    @Override
    public void deleteById(int id) {
        transactions.removeIf(t -> t.getId() == id);

    }

}
