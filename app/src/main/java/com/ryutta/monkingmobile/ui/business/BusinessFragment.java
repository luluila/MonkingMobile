package com.ryutta.monkingmobile.ui.business;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ryutta.monkingmobile.R;

public class BusinessFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private NavController navController = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_business, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.ib_menu_businessType).setOnClickListener(this);
//        ImageButton imageButton= (ImageButton) view.findViewById(R.id.ib_menu_businessType);
//        imageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_menu_businessType:
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.business_type_menu);
                popupMenu.show();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.business_type_profit:
                Toast.makeText(getContext(), "item 1 clicked", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.action_navigation_business_to_businessHistoryFragment);
                return true;
            case R.id.business_type_cost:
                Toast.makeText(getContext(), "item 2 clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}