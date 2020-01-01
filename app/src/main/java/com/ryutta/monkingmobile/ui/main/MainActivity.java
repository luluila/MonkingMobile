package com.ryutta.monkingmobile.ui.main;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ryutta.monkingmobile.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ryutta.monkingmobile.model.Data;
import com.ryutta.monkingmobile.model.ResData;
import com.ryutta.monkingmobile.ui.home.HomeFragment;
import com.ryutta.monkingmobile.ui.home_transaction_form.HomeTransactionFormActivity;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.ryutta.monkingmobile.R.id.home;
import static com.ryutta.monkingmobile.R.id.nav_host_fragment;

public class MainActivity extends AppCompatActivity implements IMain{

    MainPresenter presenter;

    RecyclerView recyclerViewRecetTransaction;

    private HomeAdapter adapter;
    private List<ResData> dataList = new ArrayList<>();

    HomeFragment homeFragment;

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

    private void showRecentTransaction() {

        presenter.showRecentTransaction();
    }

    @Override
    public void showData(List<ResData> dataList) {
        adapter = new HomeAdapter(dataList);

        recyclerViewRecetTransaction.setAdapter(adapter);
    }

    public void test(){
        Log.e("TEST", "test: test view");
    }
}
