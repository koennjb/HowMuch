package com.howmuch;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionViewHolder extends RecyclerView.ViewHolder {

    protected TextView lblTransactionListName;
    protected TextView getLblTransactionListAmount;
    protected CardView cardTransaction;

    public TransactionViewHolder(@NonNull View itemView) {
        super(itemView);
        lblTransactionListName = itemView.findViewById(R.id.lblTransactionListName);
        getLblTransactionListAmount = itemView.findViewById(R.id.lblTransactionListAmount);
        cardTransaction = itemView.findViewById(R.id.cardTransaction);
    }
}
