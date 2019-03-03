package com.howmuch;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetViewHolder> {

    List<Transaction> transactions;
    Context context;
    int lastPosition = -1;

    public BudgetAdapter(List<Transaction> budgets, Context context) {
        this.transactions = budgets;
        this.context = context;
    }

    @NonNull
    @Override
    public BudgetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_transaction, parent, false);
        BudgetViewHolder holder = new BudgetViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetViewHolder holder, int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        final Transaction transaction = transactions.get(position);

        holder.lblBudgetListName.setText(transaction.getDescription());
        NumberFormat format = NumberFormat.getCurrencyInstance();
        holder.lblBudgetListBudget.setText(format.format(transaction.getTotal()));

        holder.cardBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle budget view.
            }
        });

        if (position > lastPosition) {

            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.up_from_bottom);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
