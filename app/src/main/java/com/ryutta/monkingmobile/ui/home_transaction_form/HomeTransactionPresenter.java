package com.ryutta.monkingmobile.ui.home_transaction_form;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.model.Data;
import com.ryutta.monkingmobile.model.request.CashInRequest;
import com.ryutta.monkingmobile.model.respon.ResponseTransaction;
import com.ryutta.monkingmobile.ui.main.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

public class HomeTransactionPresenter {
    private IHomeTransaction view;
    private Data data;
    private Context context;

    public HomeTransactionPresenter(IHomeTransaction view, Data data, Context context) {
        this.view = view;
        this.data = data;
        this.context = context;
    }

    public HomeTransactionPresenter(IHomeTransaction view, Context context) {
        this.view = view;
        this.context = context;
    }

    void addCashIn(CashInRequest data){
        SharedPreferences sharedPreferences = context.getSharedPreferences("MoneyKing", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String token = sharedPreferences.getString("token","");

        Log.d("DATA", "on addCashIn: one of data"+data.getAmount());

        Log.d("TOKEN", "addCashIn: token "+token);
        Call<ResponseTransaction> call = ApiRetrofit.getInstance()
                .getApi()
                .createCashIn(token,data);

        call.enqueue(new Callback<ResponseTransaction>() {
            @Override
            public void onResponse(Call<ResponseTransaction> call, Response<ResponseTransaction> response) {

                if (response.isSuccessful()) {
                    String msg = response.body().getData().getFirstAccount()+" added ";
                    msg = msg + "\n Total amount : "+response.body().getData().getDebit();
                    Toast.makeText(context, "Transation added"+msg, LENGTH_SHORT).show();
                    Log.d("TRANSACTION RESULT", "onResponse : transaction success");
                } else {
                    Log.e("ON ADD CASH IN ", "onResponse: ERROR : "+response.code()
                    + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseTransaction> call, Throwable t) {
                String TAG = "RETROFIT";
                Toast.makeText((Context) view, "Failure add some transaction",
                        Toast.LENGTH_LONG).show();
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }

    void addCashOut(Data data, Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("MoneyKing", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String title = data.getTittle();
        String firstAccount = data.getFirstAccount();
        String secondAccount = data.getSecondAccount();
        String amount = data.getCredit();
        String token = sharedPreferences.getString("bearer","");
        Log.d("BEARER TOKEN ", "addCashOut: "+token);

        Call<ResponseTransaction> call = ApiRetrofit.getInstance()
                .getApi()
                .createCashOut(token,title, firstAccount, secondAccount, amount);

        call.enqueue(new Callback<ResponseTransaction>() {
            @Override
            public void onResponse(Call<ResponseTransaction> call, Response<ResponseTransaction> response) {
                if (response.isSuccessful()){
                    String msg = "Account : "+response.body().getData().getFirstAccount();
                    msg = msg + response.body().getData().getCredit();
                    Toast.makeText(context, "Cash Out added", LENGTH_SHORT).show();
                } else if (response!=null){
                    Log.e("ON RESPONSE NULL", "onResponse: null");
                }
            }

            @Override
            public void onFailure(Call<ResponseTransaction> call, Throwable t) {
                Log.e("ADD CASH OUT", "onFailure: "+t.getMessage());
            }
        });
    }

    void addDebt(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("MoneyKing", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String title = data.getTittle();
        String firstAccount = data.getFirstAccount();
        String secondAccount = data.getSecondAccount();
        String amount = data.getCredit();
        int personName = data.getUserId();
        String dueDate = data.getDate();
        String token = sharedPreferences.getString("bearer","");

        Call<ResponseTransaction> call = ApiRetrofit.getInstance()
                .getApi()
                .createDebt(token,title, firstAccount, secondAccount, amount, personName, dueDate);

        call.enqueue(new Callback<ResponseTransaction>() {
            @Override
            public void onResponse(Call<ResponseTransaction> call, Response<ResponseTransaction> response) {
                if (response.isSuccessful()){
                    Log.d("INSERT TRANSACTION", "Insert DEBT SUCCEST");
                    Toast.makeText(context, "Succes", LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseTransaction> call, Throwable t) {
                Toast.makeText(context, "", LENGTH_SHORT).show();
            }
        });
    }

    void addLoan(){
        String title = data.getTittle();
        String firstAccount = data.getFirstAccount();
        String secondAccount = data.getSecondAccount();
        String amount = data.getCredit();
        String dueDate = data.getCreatedAt();


//        Call<ResponseTransaction> call = ApiRetrofit.getInstance()
//                .getApi()
//                .createDebt(title, firstAccount, secondAccount, amount, personName, dueDate);

    }
}
