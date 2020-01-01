package com.ryutta.monkingmobile.ui.home_transaction_cash_out;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.model.ResData;
import com.ryutta.monkingmobile.utils.SharedPrefUtils;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTransactionCashOutFragment extends Fragment implements ICashOutView{
    @BindView(R.id.rv_cashOut_transaction)
    RecyclerView recyclerView;

    private CashOutListAdapter adapter;
    private CashOutPresenter presenter;

    public HomeTransactionCashOutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_transaction_cash_out,container,
                false);

        SharedPreferences sharedPreferences = inflater.getContext().getSharedPreferences("MoneyKing",
                inflater.getContext().MODE_PRIVATE);

        presenter = new CashOutPresenter(this, sharedPreferences.getString("token",""));
        presenter.getCashOut();

        return v;
    }

    @Override
    public void showCashOut(List<ResData> cashOutList) {
        setRecyclerView(cashOutList);
    }

    public void setRecyclerView(List<ResData> cashOutList){
        adapter = new CashOutListAdapter(cashOutList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }
}
