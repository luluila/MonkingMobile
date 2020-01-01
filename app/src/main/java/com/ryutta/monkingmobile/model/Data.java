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
    private String credit;

    @SerializedName("fm_user_id")
    private int userId;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("transaction_id")
    private String transactionId;

    public Data() { }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getFirstAccount() {
        return firstAccount;
    }

    public void setFirstAccount(String firstAccount) {
        this.firstAccount = firstAccount;
    }

    public String getSecondAccount() {
        return secondAccount;
    }

    public void setSecondAccount(String secondAccount) {
        this.secondAccount = secondAccount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
