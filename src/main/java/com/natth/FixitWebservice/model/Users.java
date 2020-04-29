package com.natth.FixitWebservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Users implements Serializable  {
    private static final long serialVersionUID = 422078653576733017L;
    private int idUsers;
    private String firstname;
    private String lastname;
    private String email;
    private String numberphone;
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_users")
    public int getIdUsers() { return idUsers; }

    public void setIdUsers(int idUsers) { this.idUsers = idUsers; }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    @Basic
    @Column(name = "lastname")
    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    @Basic
    @Column(name = "email")
    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Basic
    @Column(name = "numberphone")
    public String getNumberphone() { return numberphone; }

    public void setNumberphone(String numberphone) { this.numberphone = numberphone; }

    @Basic
    @Column(name = "password")
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return idUsers == users.idUsers &&
                Objects.equals(firstname, users.firstname) &&
                Objects.equals(lastname, users.lastname) &&
                Objects.equals(email, users.email) &&
                Objects.equals(numberphone, users.numberphone) &&
                Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsers, firstname, lastname, email, numberphone, password);
    }
}
