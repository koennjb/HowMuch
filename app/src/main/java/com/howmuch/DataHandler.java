package com.howmuch;

import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;

public class DataHandler {

    public static final String[] CATEGORIES = {"Entertainment", "Food", "Health", "Household", "Transportation", "Other"};
    public static final int ENTERTAINMENT = 0;
    public static final int FOOD = 1;
    public static final int HEALTH = 2;
    public static final int HOUSE = 3;
    public static final int TRANSPORTATION = 4;
    public static final int OTHER = 5;

    public static final String USERS_COLLECTION_PATH = "users";
    public static final String TRANSACTIONS_PATH = "transactions";

    private final String TAG = "DataHandler-Log";

    private User user;
    private String email = "email@email.com";
    private String name = "Bob Smith";
    private String id = "xyz123";

    private Transaction transaction1 = new Transaction(200.45, "03/01/2019", 0);
    private Transaction transaction2 = new Transaction(55.54, "03/02/2019", 1);
    private Transaction transaction3 = new Transaction(45, "03/03/2019", 0);
    private Transaction transaction4 = new Transaction(707.99, "03/04/2019", 1);
    private ArrayList<Transaction> transactions;

    //Actual Firebase stuff
    FirebaseFirestore db;


    public DataHandler() {
        transactions = new ArrayList<Transaction>();
        db = FirebaseFirestore.getInstance();
        user = getUser();
        addUser(user);
    }

    public User getUser() {
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        user = new User(email, name, id, transactions);
        return user;
    }

    public void addUser(User u) {
        // Add a new document with a generated ID
        db.collection(USERS_COLLECTION_PATH).document(u.getId())
                .set(u)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
        user = u;
    }

    public void getUser(String id, OnCompleteListener<DocumentSnapshot> listener) {
        try {
            DocumentReference docRef = db.collection(USERS_COLLECTION_PATH).document(id);
            docRef.get().addOnCompleteListener(listener);
        } catch (Exception e) {
            Log.d(TAG, "Document Not Found: " + id);
        }
    }

//    public String getTransactionId() {
//        return
//    }


}
