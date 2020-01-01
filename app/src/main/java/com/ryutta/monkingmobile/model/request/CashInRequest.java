package com.ryutta.monkingmobile.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CashInRequest {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("first_account")
    @Expose
    private int firstAccount;

    @SerializedName("second_account")
    @Expose
    private int secondAccount;

    @SerializedName("amount")
    @Expose
    private int amount;

    @SerializedName("date")
    @Expose
    private String date;

    public CashInRequest(String title, int firstAccount, int secondAccount, int amount, String date) {
        this.title = title;
        this.firstAccount = firstAccount;
        this.secondAccount = secondAccount;
        this.amount = amount;
        this.date = date;
    }

    public CashInRequest() {
    }

    public int getAmount() {
        return amount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstAccount(int firstAccount) {
        this.firstAccount = firstAccount;
    }

    public void setSecondAccount(int secondAccount) {
        this.secondAccount = secondAccount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
