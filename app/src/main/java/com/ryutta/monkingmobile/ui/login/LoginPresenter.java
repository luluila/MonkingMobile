package com.ryutta.monkingmobile.ui.login;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.data.remote.api.IApiEndpoint;
import com.ryutta.monkingmobile.model.request.LoginRequest;
import com.ryutta.monkingmobile.model.respon.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private static final String BEARER_TOKEN_PREFIX = "Bearer ";
    private static final String SHARED_PREF_LOGIN = "loginStatus";
    private static final String SHARED_USER_ID = "userId";
    private String USER_TOKEN="token";

    private ILoginView view;
    private Context context;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    public LoginPresenter(ILoginView view, Context context) {
        this.view = view;
        this.context = context;
    }

    void doLogin(String email, String password){
        SharedPreferences sharedPreferences = context.getSharedPreferences("MoneyKing",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        LoginRequest request = new LoginRequest(email, password);

        Call<ResponseLogin> call = ApiRetrofit.getInstance()
                .getApi()
                .login(request);

        Log.d("LOGIN REQU", new Gson().toJson(request));

        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                Log.d("LOGIN", new Gson().toJson(response.body()));
                if (response.isSuccessful()){
                    String s = response.body().getToken();
                    Log.d("LOGIN","SUCCES");
                    view.moveIntoMain();
                    String token = BEARER_TOKEN_PREFIX + s;

                    edit.putString(SHARED_PREF_LOGIN, "Login");
                    edit.putInt(SHARED_USER_ID, response.body().getUser().getId());
                    edit.putString(USER_TOKEN, token);
                    edit.commit();

                    Log.d("  token", "showRecentTransaction: "+token);
                } else {
                    Log.d("ERROR_CODE", "error");
//                    edit.putString(SHARED_PREF_LOGIN, null);

                    view.moveIntoMain();

                }

            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e("ON FAILURE LOGIN", "LOGIN ERROR: true"+t.getMessage());
             

            }
        });
    }

}