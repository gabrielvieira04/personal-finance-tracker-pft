package com.finance.tracker.model;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private double value;
    private String description;
    private LocalDate date;
    private TransactionType type;
    private Category transactionCategory;

    // Opçao de construtor caso a transacao tenha um dia
    public Transaction(int id, double value, String description, LocalDate date, TransactionType type,
            Category transactionCategory) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.date = date;
        this.type = type;
        this.transactionCategory = transactionCategory;
    }

    // Opcao caso seja no mesmo dia.
    public Transaction(int id, double value, String description, TransactionType type, Category transactionCategory) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.date = LocalDate.now();
        this.type = type;
        this.transactionCategory = transactionCategory;
    }

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Category getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(Category transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    @Override
    public String toString() {
        return "Transação #" + id + " [" + date + "] " +
                "\n  Descrição: " + description +
                "\n  Valor: R$ " + value +
                "\n  Tipo: " + (type == TransactionType.REVENUE ? "Receita" : "Despesa") +
                "\n  Categoria: " + (transactionCategory != null ? transactionCategory.getName() : "Nenhuma");
    }

}
