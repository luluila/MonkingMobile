package com.ryutta.monkingmobile.model;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("account_id")
    private int accountId;

    @SerializedName("parent_id")
    private int parentId;

    @SerializedName("company_id")
    private int companyId;

    @SerializedName("name")
    private String name;

    @SerializedName("account_code")
    private int accountCode;

    @SerializedName("amount")
    private double amount;

    @SerializedName("created_at")
    private String createdDate;

    @SerializedName("updated_at")
    private String updatedDate;
}
