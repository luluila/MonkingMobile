package com.ryutta.monkingmobile.model.respon;

import com.google.gson.annotations.SerializedName;
import com.ryutta.monkingmobile.model.Token;

public class ResponseSignup {
    @SerializedName("api_token")
    private String token;

    public String getToken() {
        return token;
    }
}
