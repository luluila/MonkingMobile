package com.ryutta.monkingmobile.base;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    protected ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBar = new ProgressBar(getContext());
    }

}
