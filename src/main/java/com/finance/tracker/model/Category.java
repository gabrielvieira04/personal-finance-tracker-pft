package com.finance.tracker.model;

public class Category {
    private String name;
    private int id;
    private TransactionType type;

    public Category (String name, int id, TransactionType type){
        this.name = name;
        this.id = id;
        this.type = type;
    }

    public Category () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
    

}
