package com.ryutta.monkingmobile.model.respon;

import com.google.gson.annotations.SerializedName;

class UserToken {
    @SerializedName("token")
    private String token;

    @SerializedName("name")
    private String userName;

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }
}
