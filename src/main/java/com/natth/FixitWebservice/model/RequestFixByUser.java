package com.natth.FixitWebservice.model;

import java.io.Serializable;

public class RequestFixByUser implements Serializable {
    private static final long serialVersionUID = 422078653576733017L;

    private int idUser;
    private String nameStore;
    private int idRequest;
    private String status;
    private String lastUpdate;
    private String firstnameUser;
    private String lastnameUser;
    private  String user_lat ;
    private  String user_lon ;
    private String tech_lat ;
    private  String tech_lon ;
    private String user_address;

    public RequestFixByUser(int idUser, String nameStore, int idRequest, String status, String lastUpdate, String firstnameUser, String lastnameUser, String user_lat, String user_lon, String tech_lat, String tech_lon, String user_address) {
        this.idUser = idUser;
        this.nameStore = nameStore;
        this.idRequest = idRequest;
        this.status = status;
        this.lastUpdate = lastUpdate;
        this.firstnameUser = firstnameUser;
        this.lastnameUser = lastnameUser;
        this.user_lat = user_lat;
        this.user_lon = user_lon;
        this.tech_lat = tech_lat;
        this.tech_lon = tech_lon;
        this.user_address = user_address;
    }

    public RequestFixByUser(){
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getFirstnameUser() {
        return firstnameUser;
    }

    public void setFirstnameUser(String firstnameUser) {
        this.firstnameUser = firstnameUser;
    }

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
    }

    public String getUser_lat() {
        return user_lat;
    }

    public void setUser_lat(String user_lat) {
        this.user_lat = user_lat;
    }

    public String getUser_lon() {
        return user_lon;
    }

    public void setUser_lon(String user_lon) {
        this.user_lon = user_lon;
    }

    public String getTech_lat() {
        return tech_lat;
    }

    public void setTech_lat(String tech_lat) {
        this.tech_lat = tech_lat;
    }

    public String getTech_lon() {
        return tech_lon;
    }

    public void setTech_lon(String tech_lon) {
        this.tech_lon = tech_lon;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
}
