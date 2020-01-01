package com.ryutta.monkingmobile.ui.home_transaction_cash_in;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.model.Account;
import com.ryutta.monkingmobile.model.ResData;
import com.ryutta.monkingmobile.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static java.util.zip.Inflater.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTransactionCashInFragment extends Fragment implements View.OnClickListener,
        PopupMenu.OnMenuItemClickListener , ICashIn{

    private NavController navController = null;
    private FloatingActionButton floatingActionButton = null;

    @BindView(R.id.rv_cashIn_transaction)
    RecyclerView recyclerView;

    List<ResData> cashInList = new ArrayList<>();

    private CashInPresenter presenter;
//    private CashInAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_transaction_cash_in, container,
                false);
        ButterKnife.bind(this, view);
        recyclerView = view.findViewById(R.id.rv_cashIn_transaction);

//        presenter = new CashInPresenter(this, container.getContext());
//        presenter.showDataCashIn();

        addDatTransaksi();
        setRecyclerView(cashInList);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.ib_cashIn_option).setOnClickListener(this);
        view.findViewById(R.id.ib_cashIn_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_cashIn_option:
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.transaction_detail_menu);
                popupMenu.show();
                break;
            case R.id.ib_cashIn_back:
                getActivity().onBackPressed();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.transaction_detail_current:
                Toast.makeText(getContext(),"Select: Current", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.transaction_detail_history:
                Toast.makeText(getContext(),"Select: History", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.transaction_detail_print:
                Toast.makeText(getContext(),"Select: Print", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.transaction_detail_share:
                Toast.makeText(getContext(),"Select: Share", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void showData(List<ResData> listData) {
//        adapter = new CashInAdapter(listData);
//
//        Log.e("ON CASH IN SHOW DATA", "showData: "+listData.get(1).getTitle());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),
//                LinearLayoutManager.VERTICAL,false));
//        cashInList = listData;

        cashInList.addAll(listData);
        setRecyclerView();
    }

    public void setRecyclerView(List<ResData> listData){
        CashInAdapter adapter = new CashInAdapter(this.cashInList);

        Log.e("ON CASH IN SHOW DATA", "showData: "+cashInList.get(1).getTitle());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),
                LinearLayoutManager.VERTICAL,false));
    }

    public void setRecyclerView(){
        CashInAdapter adapter = new CashInAdapter(this.cashInList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false));
        Log.e("ON CASH IN SHOW DATA", "showData: "+cashInList.get(1).getTitle());
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

        cashInList.add(data);
        cashInList.add(data2);
        cashInList.add(data3);

    }
}
