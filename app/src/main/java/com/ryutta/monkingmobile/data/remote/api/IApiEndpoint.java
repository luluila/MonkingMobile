package com.ryutta.monkingmobile.data.remote.api;

import com.ryutta.monkingmobile.model.Data;
import com.ryutta.monkingmobile.model.request.CashInRequest;
import com.ryutta.monkingmobile.model.request.LoginRequest;
import com.ryutta.monkingmobile.model.respon.ResponseAccount;
import com.ryutta.monkingmobile.model.respon.ResponseCompany;
import com.ryutta.monkingmobile.model.respon.ResponseCreateAccount;
import com.ryutta.monkingmobile.model.respon.ResponseLogin;
import com.ryutta.monkingmobile.model.respon.ResponseRecentTransaction;
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
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface IApiEndpoint {

//    @FormUrlEncoded
//    @POST("auth/login")
//    Call<ResponseLogin> login(
//        @Field("email") String emailUser,
//        @Field("password") String passwordUser
//    );

    @POST("auth/login")
    Call<ResponseLogin> login(@Body LoginRequest request);

    @FormUrlEncoded
    @POST("auth/signup")
    Call<ResponseSignup> signup(
            @Field("name") String userName,
            @Field("email") String emailUser,
            @Field("password") String password
    );

    @GET("auth/user")
    Call<ResponseUser> getUser(
            @Header("Authorization") String token
    );

    @POST("company")
    Call<ResponseCompany> createCompany(
            @Header("Authorization") String token,
            @Field("name") String compName,
            @Field("category") String compCategory,
            @Field("email") String compEmail,
            @Field("address") String compAddress,
            @Field("phone") String compPhone
    );

    @GET("company")
    Call<ResponseCompany> getUserCompany(
            @Header("Authorization") String token
    );

    @GET("accounts")
    Call<ResponseAccount> getCompanyAccounts(
            @Header("Authorization") String token
    );

    @PUT("accounts/{account_id}")
    Call<ResponseUpdateAccount> updateAccount(
            @Header("Authorization") String token,
            @Path("account_id") int idAccount,
            @Body String amount
    );

    @Headers("Content-Type: application/json;charset=UTF-8")
    Call<ResponseCreateAccount> createAccount(
            @Field("parent_id") int parentId,
            @Field("name") String accountName
    );

//    @FormUrlEncoded
    @POST("createCashIn")
    Call<ResponseTransaction> createCashIn(
            @Header("Authorization") String token,
            @Body CashInRequest cashInRequest
    );

    @FormUrlEncoded
    @POST("createCashOut")
    Call<ResponseTransaction> createCashOut(
            @Header("Authorization") String token,
            @Field("title") String title,
            @Field("first_account") String firstAccount,
            @Field("second_account") String secondAccount,
            @Field("amount") String amount
    );

    @Headers("User-Agent:Android")
    @POST("createDebt")
    Call<ResponseTransaction> createDebt(
            @Header("Authorization") String token,
            @Field("title") String title,
            @Field("first_account") String firstAccount,
            @Field("second_account") String secondAccount,
            @Field("amount") String amount,
            @Field("person_name") int personName,
            @Field("due_date") String dueDate
    );

    @GET("getRecent")
    Call<ResponseRecentTransaction> getRecent(
            @Header("Authorization") String token
    );

    @GET("getCashIn")
    Call<ResponseRecentTransaction> getCashIn(
            @Header("Authorization") String token
    );

    @GET("getCashOut")
    Call<ResponseRecentTransaction> getCashOut(
            @Header("Authorization") String token
    );


    @GET("getDebt")
    Call<ResponseRecentTransaction> getDebt(
            @Header("Authorization") String token
    );

    @GET("getLoan")
    Call<ResponseRecentTransaction> getLoan(
            @Header("Authorization") String token
    );

}
