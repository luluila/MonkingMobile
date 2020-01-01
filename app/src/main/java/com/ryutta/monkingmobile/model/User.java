package com.ryutta.monkingmobile.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private  int id;

    @SerializedName("name")
    private String nama;

    @SerializedName("email")
    private String email;


    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
