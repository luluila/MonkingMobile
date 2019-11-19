package com.ryutta.monkingmobile.model;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("title")
    private String tittle;

    @SerializedName("first_account")
    private String firstAccount;

    @SerializedName("second_account")
    private String secondAccount;

    @SerializedName("date")
    private String date;

    @SerializedName("debit")
    private String debit;

    @SerializedName("credit")
    private double credit;

    @SerializedName("fm_user_id")
    private int userId;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("transaction_id")
    private String transactionId;

}
