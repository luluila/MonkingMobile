package com.ryutta.monkingmobile.model.respon;

import com.google.gson.annotations.SerializedName;
import com.ryutta.monkingmobile.model.Data;

public class ResponseTransaction {
    @SerializedName("succes")
    private boolean succes;

    @SerializedName("data")
    private Data data;

    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
