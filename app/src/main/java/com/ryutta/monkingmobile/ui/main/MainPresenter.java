package com.ryutta.monkingmobile.ui.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ShareActionProvider;

import com.google.gson.Gson;
import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.model.respon.ResponseRecentTransaction;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.SharedPreferences.*;

public class MainPresenter {

    private  IMain view;
    private Context context;
    private Object Editor;

    private String USER_TOKEN_PREFIX = "Bearer ";
    private String USER_TOKEN="token";

    public MainPresenter(IMain view, Context context) {
        this.view = view;
        this.context = context;
    }

    public MainPresenter(IMain view) {
        this.view = view;
    }

    public void showRecentTransaction() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MoneyKing",
                context.MODE_PRIVATE);
        Editor = sharedPreferences.edit();
        String header = sharedPreferences.getString(USER_TOKEN,"");
        Log.d("ON MAIN", "showRecentTransaction: "+header);

        Call<ResponseRecentTransaction> call = ApiRetrofit.getInstance()
                .getApi()
                .getRecent(header);

        call.enqueue(new Callback<ResponseRecentTransaction>() {
            @Override
            public void onResponse(Call<ResponseRecentTransaction> call, Response<ResponseRecentTransaction> response) {
                Log.e("lele", call.request().headers().toString());
                if (response.isSuccessful()){
//                    view.showData(response.body().getDataList());
                    Log.d("GET LIST TRANSAKSI", new Gson().toJson(response.body().getDataList()));
                } else {
                    response.code();
                    Log.e("RESPONSE GAGAL WOEE", "Response code : "+response.code()+
                            " response error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseRecentTransaction> call, Throwable t) {
                Log.e("GAGAL", "onFailure: "+t.getMessage());
            }
        });
    }
}
