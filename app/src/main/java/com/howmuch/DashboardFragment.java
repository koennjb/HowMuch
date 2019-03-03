package com.howmuch;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    private View rootView;
    private TextView lblCat1;
    private TextView lblCat1Total;
    private TextView lblCat2;
    private TextView lblCat2Total;
    private TextView lblCat3;
    private TextView lblCat3Total;
    private Manager manager;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        lblCat1 = rootView.findViewById(R.id.lblFirstCategoryName);
        lblCat1Total = rootView.findViewById(R.id.lblFirstCategoryTotal);
        lblCat2 = rootView.findViewById(R.id.lblSecondCategoryName);
        lblCat2Total = rootView.findViewById(R.id.lblSecondCategoryTotal);
        lblCat3 = rootView.findViewById(R.id.lblThirdCategoryName);
        lblCat3Total = rootView.findViewById(R.id.lblThirdCategoryTotal);

        manager = Manager.getManager();

        updateTopCats();

        return rootView;
    }

    private void updateTopCats() {
        int[] index = new int[DataHandler.CATEGORIES.length];
        for (int i = 0; i < DataHandler.CATEGORIES.length; i++) {
            index[i] = i;
        }
        ArrayList<Double> values = new ArrayList<>();
        for (int i = 0; i < DataHandler.CATEGORIES.length; i++) {
            values.add(manager.getCategorySum(i));
        }

        for (int i = 1; i < values.size(); ++i) {
            double key = values.get(i);
            int indexKey = index[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && values.get(j) > key) {
                values.set((j + 1), values.get(j));
                index[j + 1] = index[j];
                j = j - 1;
            }
            values.set(j + 1, key);
            index[j + 1] = indexKey;
        }

        double[] max = {index[0], index[1], index[2]};
        lblCat1.setText(DataHandler.CATEGORIES[index[0]]);
        lblCat2.setText(DataHandler.CATEGORIES[index[1]]);
        lblCat3.setText(DataHandler.CATEGORIES[index[2]]);
        lblCat1Total.setText(String.valueOf(max[0]));
        lblCat2Total.setText(String.valueOf(max[0]));
        lblCat3Total.setText(String.valueOf(max[0]));
    }

}
