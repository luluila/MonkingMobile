package com.ryutta.monkingmobile.model.respon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ryutta.monkingmobile.model.User;


public class ResponseLogin {

    @Expose
    @SerializedName("api_token")
    private StringBuilder token;

    @Expose
    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token.toString();
    }

    public void setToken(String token) {
        this.token = new StringBuilder(token);
    }
}
