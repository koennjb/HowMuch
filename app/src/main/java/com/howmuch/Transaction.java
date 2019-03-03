package com.howmuch;

import android.provider.ContactsContract;

import java.util.Date;

public class Transaction {

    private double total;
    private String date;
    private String category;
    private String id;

    public String getId() {
        return id;
    }

    public Transaction() {
    }

    public Transaction(double total, String date, int category, String id) {
        this.total = total;
        this.date = date;
        this.category = DataHandler.CATEGORIES[category];
        this.id = id;
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
}
