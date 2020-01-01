package com.ryutta.monkingmobile.ui.home_transaction_debt;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.model.ResData;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTransactionDebtFragment extends Fragment implements IDebtView{

    public HomeTransactionDebtFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_transaction_debt, container, false);

        return v;
    }

    @Override
    public void showDebtList(List<ResData> debList) {

    }
}
