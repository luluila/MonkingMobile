package com.ryutta.monkingmobile.ui.home_transaction_form;

import android.content.Context;
import android.widget.Toast;

import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.model.Data;
import com.ryutta.monkingmobile.model.respon.ResponseTransaction;
import com.ryutta.monkingmobile.ui.main.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

public class HomeTransactionPresenter {
    private IHomeTransaction view;
    private Data data;

    public HomeTransactionPresenter(IHomeTransaction view, Data data) {
        this.view = view;
        this.data = data;
    }

    void addCashIn(Data data){
        String title = data.getTittle();
        String firstAccount = data.getFirstAccount();
        String secondAccount = data.getSecondAccount();
        String amount = data.getDebit();
        String date = data.getDate();

        Call<ResponseTransaction> call = ApiRetrofit.getInstance()
                .getApi()
                .createCashIn(title, firstAccount, secondAccount, amount, date);

        call.enqueue(new Callback<ResponseTransaction>() {
            @Override
            public void onResponse(Call<ResponseTransaction> call, Response<ResponseTransaction> response) {

                if (response.isSuccessful()) {
                    String msg = response.body().getData().getFirstAccount()+" added ";
                    msg = msg + "\n Total amount : "+response.body().getData().getDebit();
                    Toast.makeText((Context) view, "Transation added"+msg, LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseTransaction> call, Throwable t) {
                Toast.makeText((Context) view, "Failure add some transaction", LENGTH_SHORT).show();
            }
        });
    }

    void addCashOut(Data data, Context context){
        String title = data.getTittle();
        String firstAccount = data.getFirstAccount();
        String secondAccount = data.getSecondAccount();
        String amount = data.getCredit();

        Call<ResponseTransaction> call = ApiRetrofit.getInstance()
                .getApi()
                .createCashOut(title, firstAccount, secondAccount, amount);

        call.enqueue(new Callback<ResponseTransaction>() {
            @Override
            public void onResponse(Call<ResponseTransaction> call, Response<ResponseTransaction> response) {
                if (response.isSuccessful()){
                    String msg = "Account : "+response.body().getData().getFirstAccount();
                    msg = msg + response.body().getData().getCredit();
                    Toast.makeText(context, "Cash Out added", LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseTransaction> call, Throwable t) {

            }
        });
    }

    void addDebt(){
        String title = data.getTittle();
        String firstAccount = data.getFirstAccount();
        String secondAccount = data.getSecondAccount();
        String amount = data.getCredit();
        int personName = data.getUserId();
        String dueDate = data.getDate();

        Call<ResponseTransaction> call = ApiRetrofit.getInstance()
                .getApi()
                .createDebt(title, firstAccount, secondAccount, amount, personName, dueDate);

        call.enqueue(new Callback<ResponseTransaction>() {
            @Override
            public void onResponse(Call<ResponseTransaction> call, Response<ResponseTransaction> response) {
                
            }

            @Override
            public void onFailure(Call<ResponseTransaction> call, Throwable t) {

            }
        });
    }
}
