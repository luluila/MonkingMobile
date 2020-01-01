package com.ryutta.monkingmobile.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.model.ResData;
import com.ryutta.monkingmobile.ui.home.HomeFragment;
import com.ryutta.monkingmobile.ui.home_transaction_form.HomeTransactionFormActivity;

import java.util.ArrayList;
import java.util.List;

import static com.ryutta.monkingmobile.R.id.nav_host_fragment;

public class MainActivity extends AppCompatActivity implements IMain{

//    MainPresenter presenter;
//
//    RecyclerView recyclerViewRecetTransaction;
//
//    private HomeAdapter adapter;
//    private List<ResData> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.all_fab_new);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), HomeTransactionFormActivity.class);
                startActivity(intent);
            }
        });

        NavController navController = Navigation.findNavController(this, nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

}
