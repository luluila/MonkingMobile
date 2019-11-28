package com.ryutta.monkingmobile.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ryutta.monkingmobile.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private NavController navController = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.ib_home_cashIn).setOnClickListener(this);
        view.findViewById(R.id.ib_home_cashOut).setOnClickListener(this);
        view.findViewById(R.id.ib_home_debt).setOnClickListener(this);
        view.findViewById(R.id.ib_home_loan).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.ib_home_cashIn:
                navController.navigate(R.id.action_navigation_home_to_homeTransactionCashInFragment);
                break;
            case R.id.ib_home_cashOut:
                navController.navigate(R.id.action_navigation_home_to_homeTransactionCashOutFragment);
                break;
            case R.id.ib_home_debt:
                navController.navigate(R.id.action_navigation_home_to_homeTransactionDebtFragment);
                break;
            case R.id.ib_home_loan:
                navController.navigate(R.id.action_navigation_home_to_homeTransactionLoanFragment);
                break;
        }

    }
}