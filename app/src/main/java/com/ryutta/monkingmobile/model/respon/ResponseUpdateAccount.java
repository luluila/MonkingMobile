package com.ryutta.monkingmobile.model.respon;

import com.google.gson.annotations.SerializedName;
import com.ryutta.monkingmobile.model.Account;

public class ResponseUpdateAccount {
    @SerializedName("success")
    private boolean succes;

    @SerializedName("account")
    private Account account;

    @SerializedName("parent")
    private Account parentAccount;

    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(Account parentAccount) {
        this.parentAccount = parentAccount;
    }
}
