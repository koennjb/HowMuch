package com.howmuch;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Manager {

    private ArrayList<Transaction> transactions;
    private static Manager manager;
    private DataHandler dh;
    private User user;

    private Manager() {
        dh = new DataHandler();
        user = dh.getUser();
        transactions = user.getTransactions();
    }

    public static Manager getManager() {
        if (manager == null) {
            manager = new Manager();
            return manager;
        } else {
            return manager;
        }
    }

    public void setUser(User u) {
        this.user = u;
    }

    public void saveUser(User u) {
        dh.addUser(u);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public ArrayList<Transaction> allTransactions() {
        return transactions;
    }

    public ArrayList<Transaction> getListOfCategory(int category) {
        ArrayList<Transaction> categoryList = new ArrayList<>();
        for (Transaction trans : transactions) {
            if (trans.getCategory().equals(dh.CATEGORIES[category])) {
                categoryList.add(trans);
            }
        }
        return categoryList;
    }

    public void removeTransaction(String id) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId().equals(id)) {
                transactions.remove(i);
            }
        }
    }


}
