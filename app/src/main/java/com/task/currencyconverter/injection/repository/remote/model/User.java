package com.task.currencyconverter.injection.repository.remote.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("email")
    private String email;
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
    private String height;
    private String weight;

    public User() {

    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName The firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName The lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return The dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob The dob
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return The emergencyContact
     */
    public String getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * @param emergencyContact The emergencyContact
     */
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The userSource
     */
    public String getUserSource() {
        return userSource;
    }

    /**
     * @param userSource The userSource
     */
    public void setUserSource(String userSource) {
        this.userSource = userSource;
    }

    /**
     * @return The img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img The img
     */
    public void setImg(String img) {
        this.img = img;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", country='" + country + '\'' +
                ", userSource='" + userSource + '\'' +
                ", img='" + img + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}