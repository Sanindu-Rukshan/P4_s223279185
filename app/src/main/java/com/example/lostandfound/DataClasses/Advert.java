package com.example.lostandfound.DataClasses;

import java.io.Serializable;

public class Advert implements Serializable {
    private int id;
    private String postType;
    private String name;
    private String phoneNumber;
    private String description;
    private String date;
    private String location;

    public Advert(int id, String postType, String name, String phoneNumber, String description, String date, String location) {
        this.id = id;
        this.postType = postType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    // Getters and setters for the fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
