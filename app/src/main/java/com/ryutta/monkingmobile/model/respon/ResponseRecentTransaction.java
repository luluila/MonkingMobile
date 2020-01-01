package com.ryutta.monkingmobile.model.respon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ryutta.monkingmobile.model.ResData;

import java.util.List;

public class ResponseRecentTransaction {
    @SerializedName("succes")
    @Expose
    private boolean succes;

    @SerializedName("data")
    @Expose
    private List<ResData> dataList = null;

    public boolean isSucces() {
        return succes;
    }

    public List<ResData> getDataList() {
        return dataList;
    }
}
