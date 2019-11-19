package com.ryutta.monkingmobile.model;

import com.google.gson.annotations.SerializedName;

public class Company {
    @SerializedName("name")
    private String name;

    @SerializedName("category")
    private  String category;

    @SerializedName("email")
    private String email;

    @SerializedName("address")
    private String address;

    @SerializedName("phone")
    private String phone;

    @SerializedName("updated_at")
    private String updatedDate;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("account")
    private Account[] arrAccount;

}
