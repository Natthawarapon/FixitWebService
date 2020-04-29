package com.natth.FixitWebservice.model;

import java.io.Serializable;

public class ReviewByIdFix implements Serializable {
    private static final long serialVersionUID = 422078653576733017L;
    private int IdRequest ;
    private String TextReview ;
    private int Rating ;
    private  String LastUpdate;
    private  String FirstNameUser ;
    private  String LastNameUser ;
    private  String NameStore;

    public ReviewByIdFix(int idRequest, String textReview, int rating, String lastUpdate, String firstNameUser, String lastNameUser, String nameStore) {
        IdRequest = idRequest;
        TextReview = textReview;
        Rating = rating;
        LastUpdate = lastUpdate;
        FirstNameUser = firstNameUser;
        LastNameUser = lastNameUser;
        NameStore = nameStore;
    }

    public  ReviewByIdFix(){

    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdRequest() {
        return IdRequest;
    }

    public void setIdRequest(int idRequest) {
        IdRequest = idRequest;
    }

    public String getTextReview() {
        return TextReview;
    }

    public void setTextReview(String textReview) {
        TextReview = textReview;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getLastUpdate() {
        return LastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        LastUpdate = lastUpdate;
    }

    public String getFirstNameUser() {
        return FirstNameUser;
    }

    public void setFirstNameUser(String firstNameUser) {
        FirstNameUser = firstNameUser;
    }

    public String getLastNameUser() {
        return LastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        LastNameUser = lastNameUser;
    }

    public String getNameStore() {
        return NameStore;
    }

    public void setNameStore(String nameStore) {
        NameStore = nameStore;
    }
}
