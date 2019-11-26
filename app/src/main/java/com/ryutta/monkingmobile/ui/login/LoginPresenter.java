package com.ryutta.monkingmobile.ui.login;


import android.content.SharedPreferences;
import android.util.Log;

import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.data.remote.api.IApiEndpoint;
import com.ryutta.monkingmobile.model.respon.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ryutta.monkingmobile.utils.SharedPrefUtils.getSharedPreferences;

public class LoginPresenter {
    private static final String BEARER_TOKEN_PREFIX = "Bearer ";
    private static final String SHARED_PREF_LOGIN = "loginStatus";
    private static final String SHARED_PREF_USER_TOKEN = "tokenUser";

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
                Log.d("token",token );
                view.moveIntoMain();

                savePreference(token);
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e("onFailure : ", "Errorr");
            }
        });
    }

    void savePreference(String token){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_LOGIN, "");
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(SHARED_PREF_USER_TOKEN, token);
        editor.putBoolean(SHARED_PREF_LOGIN, true);

        editor.apply();
    }
}
