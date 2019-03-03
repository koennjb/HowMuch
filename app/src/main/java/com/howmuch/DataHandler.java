package com.howmuch;

import java.util.ArrayList;
import java.util.Date;

public class DataHandler {

    public static final String[] CATEGORIES = {"Entertainment", "Food", "Health", "Household", "Transportation", "Other"};
    public static final int ENTERTAINMENT = 0;
    public static final int FOOD = 1;
    public static final int HEALTH = 2;
    public static final int HOUSE = 3;
    public static final int TRANSPORTATION = 4;
    public static final int OTHER = 5;

    private User user;
    private String email = "email@email.com";
    private String name = "Bob Smith";
    private String id = "xyz123";

    private Transaction transaction1 = new Transaction(200.45, "03/01/2019", 0);
    private Transaction transaction2 = new Transaction(55.54, "03/02/2019", 1);
    private Transaction transaction3 = new Transaction(45, "03/03/2019", 0);
    private Transaction transaction4 = new Transaction(707.99, "03/04/2019", 1);
    private ArrayList<Transaction> transactions;

    public DataHandler() {
        transactions = new ArrayList<Transaction>();
        user  = getUser();
    }

    public User getUser() {
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        return new User(email, name, id, transactions);
    }

    public void addUser(User u) {

    }

//    public String getTransactionId() {
//        return
//    }


}
