package com.natth.FixitWebservice.model;

import java.io.Serializable;

public class RequestFixAndHistory implements Serializable {
    private static final long serialVersionUID = 422078653576733017L;

    private int idUser;
    private int idTechnician;
    private int idRequest;
    private String LastUpdate;
    private String status;
    private String user_lat;
    private String user_lon ;
    private String user_address;



    public RequestFixAndHistory(int idUser, int idTechnician, int idRequest, String lastUpdate, String status,String user_lat,String user_lon ,String user_address ) {
        this.idUser = idUser;
        this.idTechnician = idTechnician;
        this.idRequest = idRequest;
        this.LastUpdate = lastUpdate;
        this.status = status;
        this.user_lat = user_lat;
        this.user_lon = user_lon;
        this.user_address =user_address;
    }

    public RequestFixAndHistory() {

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTechnician() {
        return idTechnician;
    }

    public void setIdTechnician(int idTechnician) {
        this.idTechnician = idTechnician;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public String getLastUpdate() {
        return LastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        LastUpdate = lastUpdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser_lat() { return user_lat; }

    public void setUser_lat(String user_lat) { this.user_lat = user_lat; }

    public String getUser_lon() { return user_lon; }

    public void setUser_lon(String user_lon) { this.user_lon = user_lon; }

    public String getUser_address() { return user_address; }

    public void setUser_address(String user_address) { this.user_address = user_address; }
}
