package com.finance.tracker.repository;

import com.finance.tracker.model.Transaction;
import java.util.List;

public interface TransactionRepository {

    void save(Transaction transaction);

    List<Transaction> findAll();

    void update(Transaction transaction);

    void deleById(int id);

}
