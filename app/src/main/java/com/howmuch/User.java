package com.howmuch;

import java.util.Date;

public class User {

    private String email;
    private String name;
    private String id;
    private Transaction[] transactions;

    public User(String email, String name, String id, Transaction[] transactions) {
        this.email = email;
        this.name = name;
        this.id = id;
        this.transactions = transactions;
    }

//    public User(String email, String name, String id) {
//        this.email = email;
//        this.name = name;
//        this.id = id;
//    }

    public void newTransaction(double total, Date date, String category) {

    }

    public void getTransactions() {

    }

}
