package com.ryutta.monkingmobile.data.remote.api;

import com.ryutta.monkingmobile.model.respon.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IApiEndpoint {

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> login(
        @Field("email") String emailUser,
        @Field("password") String passwordUser
        );
}
