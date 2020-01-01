package com.ryutta.monkingmobile.ui.business;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.ryutta.monkingmobile.R;

import java.util.ArrayList;

public class BusinessFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    Group groupProfitRunning;
    Group groupProfitHistory;
    TextView barTitle;
    PieChart pieChart;

    private NavController navController = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_business, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        barTitle = view.findViewById(R.id.tv_business_barTitle);
        groupProfitRunning = view.findViewById(R.id.group_profit_running);
        groupProfitHistory = view.findViewById(R.id.group_profit_history);

        view.findViewById(R.id.ib_business_option).setOnClickListener(this);
//        view.findViewById(R.id.ib_profit_option).setOnClickListener(this);
        view.findViewById(R.id.btn_business_profit_businessTitle).setOnClickListener(this);
        view.findViewById(R.id.btn_business_profit_businessHistory).setOnClickListener(this);

        pieChart = (PieChart) view.findViewById(R.id.tv_business_profit_running_chart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.99f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList <PieEntry> yValues = new ArrayList<>();

        yValues.add(new PieEntry(80f, "Reached"));
        yValues.add(new PieEntry(20f, "Target"));

        PieDataSet dataset = new PieDataSet(yValues, "Business Profit");
        dataset.setSliceSpace(3f);
        dataset.setSelectionShift(5f);
        dataset.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataset);
        data.setValueTextSize(20f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_business_option:
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.business_type_menu);
                popupMenu.show();
                break;
//            case R.id.ib_profit_option:
//                PopupMenu popupMenu2 = new PopupMenu(view.getContext(), view);
//                popupMenu2.setOnMenuItemClickListener(this);
//                popupMenu2.inflate(R.menu.business_detail_profit_menu);
//                popupMenu2.show();
//                break;
            case R.id.btn_business_profit_businessTitle:
//                barTitle.setText("PROFIT RUNNING");
                groupProfitRunning.setVisibility(View.VISIBLE);
                groupProfitHistory.setVisibility(View.GONE);
                break;
            case R.id.btn_business_profit_businessHistory:
//                barTitle.setText("PROFIT HISTORY");
                groupProfitRunning.setVisibility(View.GONE);
                groupProfitHistory.setVisibility(View.VISIBLE);
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.business_type_profit:
                barTitle.setText("BUSINESS PROFIT");
                return true;
            case R.id.business_type_cost:
                navController.navigate(R.id.action_navigation_business_to_businessCostFragment);
                return true;
//            case R.id.business_detail_profit_running:
//                barTitle.setText("PROFIT RUNNING");
//                groupProfitRunning.setVisibility(View.VISIBLE);
//                groupProfitHistory.setVisibility(View.GONE);
//                return true;
//            case R.id.business_detail_profit_history:
//                barTitle.setText("PROFIT HISTORY");
//                groupProfitRunning.setVisibility(View.GONE);
//                groupProfitHistory.setVisibility(View.VISIBLE);
//                return true;
            default:
                return false;
        }
    }
}