package com.ryutta.monkingmobile.ui.login;


import android.util.Log;

import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.data.remote.api.IApiEndpoint;
import com.ryutta.monkingmobile.model.User;
import com.ryutta.monkingmobile.model.respon.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private static final String BEARER_TOKEN_PREFIX = "Bearer ";

    private ILoginView view;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    void doLogin(String email, String password){
        IApiEndpoint apiEndpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);

        apiEndpoint.login(email,password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                String token = BEARER_TOKEN_PREFIX+ new ResponseLogin().getToken();
                Log.d("debug : ", "OK");
                view.moveIntoMain();
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e("onFailure : ", "Errorr");
            }
        });
    }
}
