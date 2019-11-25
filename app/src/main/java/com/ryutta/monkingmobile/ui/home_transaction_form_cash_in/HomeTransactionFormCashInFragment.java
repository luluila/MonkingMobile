package com.ryutta.monkingmobile.ui.home_transaction_form_cash_in;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import com.ryutta.monkingmobile.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTransactionFormCashInFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private NavController navController = null;

    public HomeTransactionFormCashInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_transaction_form_cash_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.ib_menu_transactionForm).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_menu_businessType:
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.transaction_form_menu);
                popupMenu.show();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.transaction_form_cash_in:
                navController.navigate(R.id.action_navigation_home_to_homeTransactionFormCashInFragment);
                return true;
            case R.id.transaction_form_cash_out:
                navController.navigate(R.id.action_homeTransactionFormCashInFragment_to_homeTransactionFormCashOutFragment);
                return true;
            case R.id.transaction_form_debt:
                navController.navigate(R.id.action_homeTransactionFormCashInFragment_to_homeTransactionFormDebtFragment);
                return true;
            case R.id.transaction_form_loan:
                navController.navigate(R.id.action_homeTransactionFormCashInFragment_to_homeTransactionFormLoanFragment);
                return true;
            default:
                return false;
        }
    }
}
