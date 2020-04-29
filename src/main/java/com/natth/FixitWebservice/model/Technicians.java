package com.natth.FixitWebservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(schema = "fixitdb" , name = "users")
public class Technicians implements Serializable {
    private static final long serialVersionUID = 422078653576733017L;
    private int idTechnicians;
    private String nameStore;
    private String nameOwn;
    private String email;
    private String numberphone;
    private String latitude;
    private String longitude;
    private String password;
    private String lastUpdate;
    private String address;


    @Id
    @Column(name = "id_technicians")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getIdTechnicians() { return idTechnicians; }

    public void setIdTechnicians(int idTechnicians) {
        this.idTechnicians = idTechnicians;
    }

    @Basic
    @Column(name = "name_store")
    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    @Basic
    @Column(name = "name_own")
    public String getNameOwn() {
        return nameOwn;
    }

    public void setNameOwn(String nameOwn) {
        this.nameOwn = nameOwn;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "tel")
    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    @Basic
    @Column(name = "latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Basic
    @Column(name = "last_update")
    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }
}
