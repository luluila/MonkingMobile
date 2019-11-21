package com.ryutta.monkingmobile.ui.home_transaction_cash_in;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryutta.monkingmobile.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTransactionCashInFragment extends Fragment implements View.OnClickListener{

    private NavController navController = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_transaction_cash_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.iv_cashIn_option).setOnClickListener(this);
        view.findViewById(R.id.iv_cashIn_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_cashIn_option:
//                navController.navigate(R.id.action);
        }
    }
}
