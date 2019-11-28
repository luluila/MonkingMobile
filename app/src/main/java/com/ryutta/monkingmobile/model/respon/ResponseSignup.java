package com.ryutta.monkingmobile.model.respon;

import com.google.gson.annotations.SerializedName;

public class ResponseSignup {
    @SerializedName("api_token")
    private UserToken token;

    public UserToken getToken() {
        return token;
    }

    public void setToken(UserToken token) {
        this.token = token;
    }
}
