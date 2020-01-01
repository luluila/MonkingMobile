package com.ryutta.monkingmobile.ui.home_transaction_cash_in;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.model.ResData;
import com.ryutta.monkingmobile.model.respon.ResponseRecentTransaction;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CashInPresenter {
    private ICashIn view;
    private Context context;

    private SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;

    //shared preference
    private static final String  USER_TOKEN = "token";
    private String header = "";

    public CashInPresenter(ICashIn view, Context context) {
        this.view = view;
        this.context = context;

        sharedPreferences = context.getSharedPreferences("MoneyKing",context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        header = sharedPreferences.getString(USER_TOKEN, "");
    }

    public void showDataCashIn(){
        String TAG = "ADD DATA CASH IN";
        Log.d(TAG, "showDataCashIn: ON TOKEN: "+header);

        Call<ResponseRecentTransaction> call = ApiRetrofit.getInstance( )
                .getApi()
                .getCashIn(header);

        call.enqueue(new Callback<ResponseRecentTransaction>() {
            @Override
            public void onResponse(Call<ResponseRecentTransaction> call, Response<ResponseRecentTransaction> response) {

                if (response.isSuccessful()){
                    List<ResData> cashInList = new ArrayList<>();

                    Gson gson = new Gson();
                    Type type = new TypeToken<List<ResData>>(){}.getType();
                    String json = gson.toJson(response.body().getDataList(), type);

//                    Log.e("JSON STRING", "onResponse: "+json);

                    cashInList = gson.fromJson(json, type);
//                    Log.e("TEST GSON", "onResponse: "+tList.get(1).getTitle());

                    Log.e(TAG, "onResponse: "+cashInList.get(0).getTitle() );
                    view.showData(cashInList);
                } else {
                    Log.e(TAG, "onResponse: error"+response.code()
                    +" "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseRecentTransaction> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
