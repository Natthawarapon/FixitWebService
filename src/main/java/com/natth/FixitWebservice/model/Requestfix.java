package com.natth.FixitWebservice.model;

import org.springframework.scheduling.support.SimpleTriggerContext;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Requestfix implements Serializable {
    private static final long serialVersionUID = 422078653576733017L;
    private int idRequestFix;
    private int idUser;
    private int idTechnician;
    private String lastUpdate ;
    private String current_status;
    private String user_lat;
    private String user_lon ;
    private String user_address;



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_requestFix")
    public int getIdRequestFix() {
        return idRequestFix;
    }
    public void setIdRequestFix(int idRequestFix) {
        this.idRequestFix = idRequestFix;
    }

    @Column(name = "id_user")
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    @Column(name = "id_technician")
    public int getIdTechnician() { return idTechnician; }
    public void setIdTechnician(int idTechnician) { this.idTechnician = idTechnician; }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Column(name = "request_last_update")
    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Column(name = "current_status")
    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }

    @Column(name = "user_lat")
    public String getUser_lat() { return user_lat; }

    public void setUser_lat(String user_lat) { this.user_lat = user_lat; }

    @Column(name = "user_lon")
    public String getUser_lon() { return user_lon; }

    public void setUser_lon(String user_lon) { this.user_lon = user_lon; }

    @Column(name = "user_address")
    public String getUser_address() { return user_address; }
    public void setUser_address(String user_address) { this.user_address = user_address; }
}
