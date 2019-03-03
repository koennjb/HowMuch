package com.howmuch;

public class Transaction {

    private double total;
    private String date;
    private String category;
    private String id;
    private String description;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Transaction() {

    }

    public Transaction(String description, double total, String date, int category) {
        this.description = description;
        this.total = total;
        this.date = date;
        this.category = DataHandler.CATEGORIES[category];
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = DataHandler.CATEGORIES[category];
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
