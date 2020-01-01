package com.ryutta.monkingmobile.ui.business_cost;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.base.BaseFragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BusinessCostFragment extends BaseFragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    Group groupCostRunning;
    Group groupCostHistory;
    TextView barTitle;
    PieChart pieChart;

    private NavController navController = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_business_cost, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        barTitle = view.findViewById(R.id.tv_business_barTitle);
        groupCostRunning = view.findViewById(R.id.group_cost_running);
        groupCostHistory = view.findViewById(R.id.group_cost_history);

        view.findViewById(R.id.ib_business_option).setOnClickListener(this);
//        view.findViewById(R.id.ib_cost_option).setOnClickListener(this);
        view.findViewById(R.id.btn_business_cost_businessTitle).setOnClickListener(this);
        view.findViewById(R.id.btn_business_cost_businessHistory).setOnClickListener(this);

        pieChart = (PieChart) view.findViewById(R.id.chart_business_cost_running_pie_chart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.99f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<>();

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
        switch (view.getId()) {
            case R.id.ib_business_option:
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.business_type_menu);
                popupMenu.show();
                break;
//            case R.id.ib_cost_option:
//                PopupMenu popupMenu2 = new PopupMenu(view.getContext(), view);
//                popupMenu2.setOnMenuItemClickListener(this);
//                popupMenu2.inflate(R.menu.business_detail_cost_menu);
//                popupMenu2.show();
//                break;
            case R.id.btn_business_cost_businessTitle:
//                barTitle.setText("COST RUNNING");
                groupCostRunning.setVisibility(View.VISIBLE);
                groupCostHistory.setVisibility(View.GONE);
            case R.id.btn_business_cost_businessHistory:
//                barTitle.setText("COST HISTORY");
                groupCostRunning.setVisibility(View.GONE);
                groupCostHistory.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.business_type_profit:
                barTitle.setText("BUSINESS PROFIT");
                getActivity().onBackPressed();
                return true;
            case R.id.business_type_cost:
                return true;
//            case R.id.business_detail_cost_running:
//                barTitle.setText("COST RUNNING");
//                groupCostRunning.setVisibility(View.VISIBLE);
//                groupCostHistory.setVisibility(View.GONE);
//                return true;
//            case R.id.business_detail_cost_history:
//                barTitle.setText("COST HISTORY");
//                groupCostRunning.setVisibility(View.GONE);
//                groupCostHistory.setVisibility(View.VISIBLE);
//                return true;
            default:
                return false;
        }
    }
}
