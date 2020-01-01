package com.ryutta.monkingmobile.model;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("token")
    private String token;

    @SerializedName("name")
    private String name;

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }
}
