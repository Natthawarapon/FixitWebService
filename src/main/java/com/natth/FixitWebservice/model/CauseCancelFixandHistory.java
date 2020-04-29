package com.natth.FixitWebservice.model;

public class CauseCancelFixandHistory  {
    private static final long serialVersionUID = 422078653576733017L;
    private int idFix ;
    private  String cause;
    private  String status;
    private  String last_update;
    private String name_store;
    public CauseCancelFixandHistory(int idFix, String cause, String status ,String last_update ,String name_store) {
        this.idFix = idFix;
        this.cause = cause;
        this.status = status;
        this.last_update = last_update;
        this.name_store = name_store;

    }

    public CauseCancelFixandHistory() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdFix() {
        return idFix;
    }

    public void setIdFix(int idFix) {
        this.idFix = idFix;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getName_store() {
        return name_store;
    }

    public void setName_store(String name_store) {
        this.name_store = name_store;
    }
}
