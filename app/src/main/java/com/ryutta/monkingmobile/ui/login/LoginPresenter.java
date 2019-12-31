package com.ryutta.monkingmobile.ui.login;


import android.content.SharedPreferences;
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
    private static final String SHARED_PREF_LOGIN = "loginStatus";
    private static final String SHARED_PREF_USER_TOKEN = "tokenUser";

    private ILoginView view;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    void doLogin(String email, String password){
        Call<ResponseLogin> call = ApiRetrofit.getInstance()
                .getApi()
                .login(email, password);


        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()){

                    String s = response.body().getToken();
                    Log.d("LOGIN","SUCCES");
                    view.moveIntoMain();
                    String token = response.body().getToken();
                    Log.d("token", "onResponse: "+token);
                } else {
                    Log.d("ERROR_CODE", "error");
                    view.moveIntoMain();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e("LOGIN", "LOGIN ERROR: true");
                view.moveIntoMain();
            }
        });
    }

}