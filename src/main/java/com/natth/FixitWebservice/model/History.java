package com.natth.FixitWebservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class History implements Serializable {
    private static final long serialVersionUID = 422078653576733017L;
    private int idHistory;
    private int idRequest;
    private String LastUpdate;
    private String status;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_history")
    public int getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(int idHistory) {
        this.idHistory = idHistory;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Column(name = "history_last_update")
    public String getLastUpdate() {
        return LastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        LastUpdate = lastUpdate;
    }

    @Column(name = "id_request")
    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }


    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
