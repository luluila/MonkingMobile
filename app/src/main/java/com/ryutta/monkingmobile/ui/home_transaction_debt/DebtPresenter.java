package com.ryutta.monkingmobile.ui.home_transaction_debt;

import android.util.Log;
import android.widget.Toast;

import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.data.remote.api.IApiEndpoint;
import com.ryutta.monkingmobile.model.respon.ResponseRecentTransaction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DebtPresenter {
    private IDebtView view;
    private String header;

    public DebtPresenter(IDebtView view, String header) {
        this.view = view;
        this.header = header;
    }

    public void getAllDebt(){
        ApiRetrofit.getInstance().getApi().getDebt(header).
                enqueue(new Callback<ResponseRecentTransaction>() {
                    @Override
                    public void onResponse(Call<ResponseRecentTransaction> call, Response<ResponseRecentTransaction> response) {
                        if (response.isSuccessful()){
                            view.showDebtList(response.body().getDataList());
                            Log.e("ON DEBT SCS", "onResponse: "+response.body().
                                    getDataList().get(0).getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseRecentTransaction> call, Throwable t) {
//                        Toast.makeText(view, "", Toast.LENGTH_SHORT).show();
                        Log.e("ON FAILURE DEBT", "onFailure: "+t.getMessage());
                    }
                });

    }
}
