package com.ryutta.monkingmobile.ui.home_transaction_cash_out;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.model.Account;
import com.ryutta.monkingmobile.model.ResData;
import com.ryutta.monkingmobile.utils.SharedPrefUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTransactionCashOutFragment extends Fragment implements ICashOutView{
//    @BindView(R.id.rv_cashOut_transaction)
    RecyclerView recyclerView;

    private CashOutListAdapter adapter;
    private CashOutPresenter presenter;

    private List<ResData> cashOutList = new ArrayList<>();

//    public HomeTransactionCashOutFragment() {
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_transaction_cash_out,container,
                false);
        ButterKnife.bind(this, v);

        recyclerView = v.findViewById(R.id.rv_cashOut_transaction);
        if (recyclerView==null){
            Log.e("RECYCLER VIEW", "NULL recycler");
        }

        SharedPreferences sharedPreferences = inflater.getContext().getSharedPreferences("MoneyKing",
                inflater.getContext().MODE_PRIVATE);

//        presenter = new CashOutPresenter(this, sharedPreferences.getString("token",""));
//        presenter.getCashOut();

        addDatTransaksi();
        setRecyclerView(cashOutList);

        return v;
    }

    @Override
    public void showCashOut(List<ResData> cashOutList) {
        Log.e("ON SHOW CASH OUT", "showCashOut: "+cashOutList.get(0).
                getTitle());
        adapter = new CashOutListAdapter(cashOutList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));

//        setRecyclerView(cashOutList);
    }

    public void setRecyclerView(List<ResData> cashOutList){
        adapter = new CashOutListAdapter(cashOutList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    public void addDatTransaksi(){
        ResData data = new ResData();

        Account firsAccount = new Account();
        firsAccount.setAccountId(13);

        Account secondAccount = new Account();
        secondAccount.setAccountId(6);

        data.setBudgetId(1);
        data.setUserId(1);
        data.setBudgetId(1);
        data.setFirstAccount(firsAccount);
        data.setSecondAccount(secondAccount);
        data.setTitle("Pembelian hape");
        data.setDebit(1000000);
        data.setDate("2019-11-26");

        ResData data2 = new ResData();
        data2.setBudgetId(1);
        data2.setUserId(1);
        data2.setBudgetId(1);
        data2.setFirstAccount(firsAccount);
        data2.setSecondAccount(secondAccount);
        data2.setTitle("Pembelian minum");
        data2.setDebit(1000000);
        data2.setDate("2019-11-26");

        ResData data3 = new ResData();

        data3.setBudgetId(1);
        data3.setUserId(1);
        data3.setBudgetId(1);
        data3.setFirstAccount(firsAccount);
        data3.setSecondAccount(secondAccount);
        data3.setTitle("Hutang ATK");
        data3.setDebit(1000000);
        data3.setDate("2019-11-26");

        cashOutList.add(data);
        cashOutList.add(data2);
        cashOutList.add(data3);

    }
}
