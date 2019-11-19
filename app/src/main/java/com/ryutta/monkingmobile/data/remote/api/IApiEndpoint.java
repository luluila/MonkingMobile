package com.ryutta.monkingmobile.data.remote.api;

import com.google.gson.JsonObject;
import com.ryutta.monkingmobile.model.respon.ResponseAccount;
import com.ryutta.monkingmobile.model.respon.ResponseCompany;
import com.ryutta.monkingmobile.model.respon.ResponseCreateAccount;
import com.ryutta.monkingmobile.model.respon.ResponseCreateCompany;
import com.ryutta.monkingmobile.model.respon.ResponseLogin;
import com.ryutta.monkingmobile.model.respon.ResponseSignup;
import com.ryutta.monkingmobile.model.respon.ResponseTransaction;
import com.ryutta.monkingmobile.model.respon.ResponseUpdateAccount;
import com.ryutta.monkingmobile.model.respon.ResponseUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IApiEndpoint {

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> login(
        @Field("email") String emailUser,
        @Field("password") String passwordUser
        );

    @POST("signup")
    Call<ResponseSignup> signup(
            @Field("name") String userName,
            @Field("email") String emailUser,
            @Field("password") String password
    );

    @GET("user")
    Call<ResponseUser> getUser(

    );

    @POST("company")
    Call<ResponseCompany> createCompany(
            @Field("name") String compName,
            @Field("category") String compCategory,
            @Field("email") String compEmail,
            @Field("address") String compAddress,
            @Field("phone") String compPhone
    );

    @GET("company")
    Call<ResponseCompany> getUserCompany(

    );

    @GET("accounts")
    Call<ResponseAccount> getCompanyAccounts(

    );

    @PUT("accounts/{account_id}")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Call<ResponseUpdateAccount> updateAccount(
            @Body String amount
    );

    @POST("accounts")
    Call<ResponseCreateAccount> createAccount(
            @Field("parent_id") int parentId,
            @Field("name") String accountName
    );

    @POST("createCashIn")
    Call<ResponseTransaction> createCashIn(
            @Field("title") String transTitle,
            @Field("first_account") String firstAccount,
            @Field("second_account") String secondAccount,
            @Field("amount") double amount,
            @Field("date") String date
    );

    @POST("createCashOut")
    Call<ResponseTransaction> createCashOut(
            @Field("title") String title,
            @Field("first_account") int firstAccount,
            @Field("second_account") int secondAccount,
            @Field("amount") double amount
    );

    @POST("createDebt")
    Call<ResponseTransaction> createDebt(
            @Field("title") String title,
            @Field("first_account") String firstAccount,
            @Field("second_account") String secondAccount,
            @Field("amount") double amount,
            @Field("person_name") String personName,
            @Field("due_date") String dueDate
    );
}
