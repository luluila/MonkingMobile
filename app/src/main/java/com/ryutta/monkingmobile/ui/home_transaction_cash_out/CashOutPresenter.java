package com.ryutta.monkingmobile.ui.home_transaction_cash_out;

import android.util.Log;

import com.google.gson.Gson;
import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.data.remote.api.IApiEndpoint;
import com.ryutta.monkingmobile.model.respon.ResponseRecentTransaction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CashOutPresenter {
    private ICashOutView view;
    private String header;

    public CashOutPresenter(ICashOutView view, String header) {
        this.view = view;
        this.header = header;
    }

    protected void getCashOut(){
        ApiRetrofit.getInstance().getApi().getCashOut(header).enqueue(new Callback<ResponseRecentTransaction>() {
            @Override
            public void onResponse(Call<ResponseRecentTransaction> call, Response<ResponseRecentTransaction> response) {
                if (response.isSuccessful()){
                    view.showCashOut(response.body().getDataList());
                    Log.e("ON CASH OUT", new Gson().toJson(response.body().getDataList()));
                }
            }

            @Override
            public void onFailure(Call<ResponseRecentTransaction> call, Throwable t) {
                Log.e("ON FAILURE ", "onFailure: "+t.getMessage());
            }
        });
    }
}
