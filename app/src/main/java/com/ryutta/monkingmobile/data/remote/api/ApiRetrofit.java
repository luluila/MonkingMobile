package com.ryutta.monkingmobile.data.remote.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit {

    public static final String BASE_URL = "https://monking.herokuapp.com/api/";
    private static Retrofit retrofit;
    private static ApiRetrofit mInstance;


    private ApiRetrofit(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
    }


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
