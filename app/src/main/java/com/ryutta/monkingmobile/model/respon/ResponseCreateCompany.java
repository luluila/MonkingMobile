package com.ryutta.monkingmobile.model.respon;

import com.google.gson.annotations.SerializedName;
import com.ryutta.monkingmobile.model.Company;

public class ResponseCreateCompany {
    @SerializedName("success")
    private boolean success;

    @SerializedName("company")
    private Company company;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
