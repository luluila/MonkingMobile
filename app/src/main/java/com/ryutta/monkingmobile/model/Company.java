package com.ryutta.monkingmobile.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Objects;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Account[] getArrAccount() {
        return arrAccount;
    }

    public void setArrAccount(Account[] arrAccount) {
        this.arrAccount = arrAccount;
    }
}
