package com.ryutta.monkingmobile.model.respon;

import com.google.gson.annotations.SerializedName;
import com.ryutta.monkingmobile.model.Account;

public class ResponseAccount {
    @SerializedName("succes")
    private boolean succes;

    @SerializedName("account")
    private Account account[];
}
