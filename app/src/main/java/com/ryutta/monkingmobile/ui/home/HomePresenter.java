package com.ryutta.monkingmobile.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.model.ResData;
import com.ryutta.monkingmobile.model.respon.ResponseRecentTransaction;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    private IHomeView view;
    private Context context;

    private SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;

    //shared preference
    private static final String  USER_TOKEN = "token";
    private String header = "";

    List<ResData> tList = new ArrayList<>();
    public HomePresenter(IHomeView view, Context context) {
        this.view = view;
        this.context = context;

        sharedPreferences = context.getSharedPreferences("MoneyKing",context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        header = sharedPreferences.getString(USER_TOKEN, "");
    }

    void getAllRecentTransaction(){
        retrofit2.Call<ResponseRecentTransaction> call = ApiRetrofit.getInstance()
                .getApi()
                .getRecent(header);

        call.enqueue(new Callback<ResponseRecentTransaction>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseRecentTransaction> call, Response<ResponseRecentTransaction> response) {
                Log.e("lele", call.request().headers().toString());
                if (response.isSuccessful()){

                    Gson gson = new Gson();
                    Type type = new TypeToken<List<ResData>>(){}.getType();
                    String json = gson.toJson(response.body().getDataList(), type);

//                    Log.e("JSON STRING", "onResponse: "+json);

                    tList = gson.fromJson(json, type);
//                    Log.e("TEST GSON", "onResponse: "+tList.get(1).getTitle());

                    view.showListTransactions(tList);
                } else {
                    response.code();
                    Log.e("RESPONSE ", "Response code : "+response.code()+
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
