package com.ryutta.monkingmobile.utils;

import android.app.Activity;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class CommunicationUtils {

    public static void changeActivity(){}

    public static void switchFragment(@NonNull FragmentManager fragmentManager,
                                      @IdRes int containerViewId,
                                      @NonNull Fragment fragment,
                                      @Nullable String fragmentTag,
                                      @Nullable String backStackStateName){

        fragmentManager
                .beginTransaction()
                .replace(containerViewId, fragment, fragmentTag)
                .addToBackStack(backStackStateName)
                .commit();
    }
}
