package com.ryutta.monkingmobile.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.model.Account;
import com.ryutta.monkingmobile.model.ResData;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener,IHomeView {
    private List<ResData> transactionList = new ArrayList<>();

    private ListTransactionAdapter adapter;
    private HomePresenter presenter;

    private NavController navController = null;

    @BindView(R.id.rv_home_transaction)
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this,view);

        presenter = new HomePresenter(this,this.getContext());
        presenter.getAllRecentTransaction();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.ib_home_cashIn).setOnClickListener(this);
        view.findViewById(R.id.ib_home_cashOut).setOnClickListener(this);
        view.findViewById(R.id.ib_home_debt).setOnClickListener(this);
        view.findViewById(R.id.ib_home_loan).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.ib_home_cashIn:
                navController.navigate(R.id.action_navigation_home_to_homeTransactionCashInFragment);
                break;
            case R.id.ib_home_cashOut:
                navController.navigate(R.id.action_navigation_home_to_homeTransactionCashOutFragment);
                break;
            case R.id.ib_home_debt:
                navController.navigate(R.id.action_navigation_home_to_homeTransactionDebtFragment);
                break;
            case R.id.ib_home_loan:
                navController.navigate(R.id.action_navigation_home_to_homeTransactionLoanFragment);
                break;
        }

    }

    private void setRecyclerView(){
        adapter = new ListTransactionAdapter(this.transactionList, this.getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void showListTransactions(List<ResData> dataTransaction) {
//        Log.e("DATA TRANS", "showListTransactions: "+dataTransaction.get(0).getTitle());
        transactionList = dataTransaction;
        Log.e("DATA TRANS", "showListTransactions: "+transactionList.get(0).getTitle());
//        this.transactionList.addAll(dataTransaction);
        setRecyclerView();
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

        transactionList.add(data);
        transactionList.add(data2);
        transactionList.add(data3);

    }


}