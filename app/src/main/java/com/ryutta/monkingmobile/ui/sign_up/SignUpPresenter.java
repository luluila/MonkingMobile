package com.ryutta.monkingmobile.ui.sign_up;

import android.util.Log;
import android.widget.Toast;

import com.ryutta.monkingmobile.data.remote.api.ApiRetrofit;
import com.ryutta.monkingmobile.data.remote.api.IApiEndpoint;
import com.ryutta.monkingmobile.model.respon.ResponseSignup;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpPresenter {

    private ISignUp view;

    public SignUpPresenter(ISignUp signUp) {
        this.view = signUp;
    }

    void doSignUp(String name, String email, String password){
        Log.d("password", password);
        Call<ResponseSignup> call = ApiRetrofit.getInstance()
                .getApi()
                .signup(name, email, password);

        call.enqueue(new Callback<ResponseSignup>() {
            @Override
            public void onResponse(Call<ResponseSignup> call, Response<ResponseSignup> response) {
                String s = response.body().toString();
                Log.d("RESPONSE BODY", s);
                if (response.isSuccessful()){
                    Log.d("success", "success sign up");
                    view.moveToLogin();
                } else{
                    String error = null;
                    try {
                        error = response.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.e("Error", error);
                }
            }

            @Override
            public void onFailure(Call<ResponseSignup> call, Throwable t) {
                Log.e("error", "cannot sign up trowable error");
                Log.e("TROWABLE", "onFailure: ");
            }
        });

    }
}
