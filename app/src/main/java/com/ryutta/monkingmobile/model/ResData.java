package com.ryutta.monkingmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResData {
    @SerializedName("transaction_id")
    @Expose
    private int transId;

    @SerializedName("fm_user_id")
    @Expose
    private int userId;

    @SerializedName("budget_center_id")
    @Expose
    private int budgetId;

    @SerializedName("first_account")
    @Expose
    private Account firstAccount;

    @SerializedName("second_account")
    @Expose
    private Account secondAccount;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("debit")
    @Expose
    private int debit;

    @SerializedName("credit")
    @Expose
    private int credit;

    @SerializedName("date")
    @Expose
    private String date;

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public Account getFirstAccount() {
        return firstAccount;
    }

    public void setFirstAccount(Account firstAccount) {
        this.firstAccount = firstAccount;
    }

    public Account getSecondAccount() {
        return secondAccount;
    }

    public void setSecondAccount(Account secondAccount) {
        this.secondAccount = secondAccount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
