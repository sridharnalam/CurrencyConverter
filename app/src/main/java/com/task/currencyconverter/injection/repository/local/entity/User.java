package com.task.currencyconverter.injection.repository.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sridhar Nalam on 11-09-2017.
 */

@Entity(indices = {@Index("phone"), @Index("key")},
        primaryKeys = {"email"})
public class User {

    @SerializedName("email")
    private String emailId;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("phone")
    private String phone;
    @SerializedName("dob")
    private String dob;
    @SerializedName("gender")
    private String gender;
    @SerializedName("emergencyContact")
    private String emergencyContact;
    @SerializedName("country")
    private String country;
    @SerializedName("userSource")
    private String userSource;
    @SerializedName("img")
    private String img;
    @SerializedName("key")
    private String userKey;
    private float height;
    private float weight;
}
