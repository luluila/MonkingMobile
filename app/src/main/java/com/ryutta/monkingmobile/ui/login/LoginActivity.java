package com.ryutta.monkingmobile.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ryutta.monkingmobile.base.BaseActivity;
import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.data.remote.api.IApiEndpoint;
import com.ryutta.monkingmobile.model.respon.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    private String api_token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        IApiEndpoint apiEndpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);

        apiEndpoint.login("Faiz@monking.com","faiz1234").enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                Log.e("lele",call.request().toString());
                Log.e("lala", response.toString());
                api_token = response.body().getToken();
                Log.d("debug : ", "OK");
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e("onFailure : ", "Errorr");
            }
        });
    }
}
