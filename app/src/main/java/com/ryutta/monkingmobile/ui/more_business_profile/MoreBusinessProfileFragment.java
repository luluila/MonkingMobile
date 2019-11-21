package com.ryutta.monkingmobile.ui.more_business_profile;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryutta.monkingmobile.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreBusinessProfileFragment extends Fragment {


    public MoreBusinessProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more_business_profile, container, false);
    }

}
