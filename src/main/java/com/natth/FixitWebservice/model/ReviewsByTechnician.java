package com.natth.FixitWebservice.model;

import java.io.Serializable;


public class ReviewsByTechnician implements Serializable {
    private static final long serialVersionUID = 422078653576733017L;
    private int idTechnicians;
    private String nameStore;
    private String firstname;
    private String lastname;
    private String textrevew;
    private String lastUpdate;
    private int rating ;

    public ReviewsByTechnician(int idTechnicians, String firstname, String lastname, String textrevew, String lastUpdate, int rating) {
        this.idTechnicians = idTechnicians;
        this.firstname = firstname;
        this.lastname = lastname;
        this.textrevew = textrevew;
        this.lastUpdate = lastUpdate;
        this.rating = rating;
    }

    public ReviewsByTechnician() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdTechnicians() {
        return idTechnicians;
    }

    public void setIdTechnicians(int idTechnicians) {
        this.idTechnicians = idTechnicians;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTextrevew() {
        return textrevew;
    }

    public void setTextrevew(String textrevew) {
        this.textrevew = textrevew;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
