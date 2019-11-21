package com.ryutta.monkingmobile.ui.more_setting;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryutta.monkingmobile.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreSettingFragment extends Fragment {


    public MoreSettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more_setting, container, false);
    }

}
