package com.ryutta.monkingmobile.ui.sign_up;

import android.util.Log;

import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.data.remote.api.IApiEndpoint;
import com.ryutta.monkingmobile.model.respon.ResponseSignup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpPresenter {

    private ISignUp view;

    public SignUpPresenter(ISignUp signUp) {
        this.view = signUp;
    }

    void doSignUp(String email, String password, String rewPassword){
        if (password.equals(rewPassword)){
            IApiEndpoint apiEndpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
            apiEndpoint.signup(email, password, rewPassword).enqueue(new Callback<ResponseSignup>() {
                @Override
                public void onResponse(Call<ResponseSignup> call, Response<ResponseSignup> response) {
                    view.moveToLogin();
                    Log.d("succes", "succes sign up");
                }

                @Override
                public void onFailure(Call<ResponseSignup> call, Throwable t) {
                    Log.e("error", "cannot sign up");
                }
            });
        }
    }
}
