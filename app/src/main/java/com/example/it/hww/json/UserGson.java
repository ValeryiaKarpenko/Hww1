package com.example.it.hww.json;

import com.google.gson.annotations.SerializedName;

public class UserGson implements IUser {

    @SerializedName("id")
    private long mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("surname")
    private String mSurname;

    @SerializedName("male")
    private String mMale;

    @SerializedName("age")
    private int mAge;

    @Override
    public long getId() {
        return mId;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public String getSurname() {
        return mSurname;
    }

    @Override
    public String getMale() {
        return mMale;
    }

    @Override
    public int getAge() {
        return mAge;
    }
}
