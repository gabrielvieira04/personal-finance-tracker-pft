package com.finance.tracker.model;
import java.time.LocalDate;

public class Transaction {
    private int id;
    private double value;
    private String description;
    private LocalDate date;
    private TransactionType type;
    
    //Opçao de construtor caso a transacao tenha um dia
    public Transaction (int id, double value, String description, LocalDate date, TransactionType type) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.date = date;
        this.type = type;
    }
    
    //Opcao caso seja no mesmo dia.
    public Transaction (int id, double value, String description, TransactionType type) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.date = LocalDate.now();
        this.type = type;
    }


    public Transaction (){}

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

    

}
