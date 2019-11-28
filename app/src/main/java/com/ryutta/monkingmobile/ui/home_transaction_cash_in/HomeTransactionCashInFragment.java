package com.ryutta.monkingmobile.ui.home_transaction_cash_in;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ryutta.monkingmobile.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTransactionCashInFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private NavController navController = null;
    private FloatingActionButton floatingActionButton = null;

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
        view.findViewById(R.id.ib_cashIn_option).setOnClickListener(this);
        view.findViewById(R.id.ib_cashIn_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_cashIn_option:
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.transaction_detail_menu);
                popupMenu.show();
                break;
            case R.id.ib_cashIn_back:
                getActivity().onBackPressed();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.transaction_detail_current:
                Toast.makeText(getContext(),"Select: Current", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.transaction_detail_history:
                Toast.makeText(getContext(),"Select: History", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.transaction_detail_print:
                Toast.makeText(getContext(),"Select: Print", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.transaction_detail_share:
                Toast.makeText(getContext(),"Select: Share", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}
