package com.ryutta.monkingmobile.model.respon;

import com.google.gson.annotations.SerializedName;
import com.ryutta.monkingmobile.model.Account;

public class ResponseCreateAccount {
    @SerializedName("succes")
    private boolean succes;

    @SerializedName("account")
    private Account account;

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
}
