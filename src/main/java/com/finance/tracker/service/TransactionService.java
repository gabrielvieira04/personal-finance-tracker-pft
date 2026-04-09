package com.finance.tracker.service;

import com.finance.tracker.repository.TransactionRepository;

public class TransactionService {

    private TransactionRepository repository;

    public TransactionService (TransactionRepository repository){
        this.repository = repository;
    }

}
