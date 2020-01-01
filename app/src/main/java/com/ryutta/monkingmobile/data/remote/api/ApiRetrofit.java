package com.ryutta.monkingmobile.data.remote.api;

import android.content.Intent;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.xml.sax.ErrorHandler;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.core.content.ContextCompat.startActivity;

public class ApiRetrofit {

    public static final String BASE_URL = "https://monking.herokuapp.com/api/";
    private static Retrofit retrofit;
    private static ApiRetrofit mInstance;

//    private ApiRetrofit(String token){
//
//        if(retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//
//        }
//    }

    private ApiRetrofit(){

//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        OkHttpClient client = builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
//
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .client(client)
                    .build();

        }
    }

//    public static synchronized ApiRetrofit getInstance(String token){
//        if (mInstance == null){
//            mInstance = new ApiRetrofit(token);
//        }
//        return mInstance;
//    }

    public static synchronized ApiRetrofit getInstance(){
        if (mInstance == null){
            mInstance = new ApiRetrofit();
        }
        return mInstance;
    }

    public IApiEndpoint getApi(){
        return  retrofit.create(IApiEndpoint.class);
    }
}
