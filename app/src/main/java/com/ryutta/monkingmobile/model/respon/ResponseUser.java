package com.ryutta.monkingmobile.model.respon;

import com.google.gson.annotations.SerializedName;
import com.ryutta.monkingmobile.model.User;

public class ResponseUser {
    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
