package com.howmuch;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.NonNull;

public class Manager {

    private ArrayList<Transaction> transactions;
    private static Manager manager;
    private DataHandler dh;
    private User user;

    private FirebaseFirestore firebaseDB;

    private Manager() {
        dh = new DataHandler();
        firebaseDB = FirebaseFirestore.getInstance();
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

    public User getUser() {
        return user;
    }

    public void loadUser(String id, OnCompleteListener<DocumentSnapshot> listener) {
        DocumentReference docRef = firebaseDB.collection(DataHandler.USERS_COLLECTION_PATH).document(id);
        docRef.get().addOnCompleteListener(listener);
    }


}
