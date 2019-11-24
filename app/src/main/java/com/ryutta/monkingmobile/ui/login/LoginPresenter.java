package com.ryutta.monkingmobile.ui.login;


import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.data.remote.api.IApiEndpoint;
import com.ryutta.monkingmobile.model.User;
import com.ryutta.monkingmobile.model.respon.ResponseLogin;
import com.ryutta.monkingmobile.utils.SharedPrefUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ryutta.monkingmobile.utils.SharedPrefUtils.getSharedPreferences;

public class LoginPresenter {
    private static final String BEARER_TOKEN_PREFIX = "Bearer ";

    private ILoginView view;
    private static SharedPrefUtils sharedPrefUtils;
    private ResponseLogin responseLogin;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    void doLogin(String email, String password){
        String token = BEARER_TOKEN_PREFIX + responseLogin.getToken();

        IApiEndpoint apiEndpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);


        apiEndpoint.login(email,password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                String token = BEARER_TOKEN_PREFIX+ new ResponseLogin().getToken();
                Log.d("debug : ", "OK");
                Log.d("token",token );
                view.moveIntoMain();
                SharedPrefUtils.setStringSharedPref("LOGIN_TOKEN",token);
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e("onFailure : ", "Errorr");
            }
        });
    }
}
