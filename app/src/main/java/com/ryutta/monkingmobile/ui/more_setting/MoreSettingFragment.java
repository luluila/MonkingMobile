package com.ryutta.monkingmobile.ui.more_setting;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryutta.monkingmobile.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreSettingFragment extends Fragment implements View.OnClickListener {

    private NavController navController = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.ib_more_next_businessProfile);
        view.findViewById(R.id.ib_more_next_target);
        view.findViewById(R.id.ib_more_next_account);
        view.findViewById(R.id.ib_more_next_setting);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_more_next_businessProfile:
                navController.navigate(R.id.action_navigation_more_to_moreBusinessProfileFragment);
                break;
            case R.id.ib_more_next_setting:
                navController.navigate(R.id.action_navigation_more_to_moreSettingFragment);
                break;
        }
    }
}
