package com.addressBookApp.auth;

import jakarta.persistence.*;

@Entity
@Table
public class Auth {
    @Id
    @SequenceGenerator(
            name = "auth_sequence",
            sequenceName = "auth_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "auth_sequence"
    )
    private String logon;
    private String password;

    public Auth() {
    }

    public Auth(String logon,
                String password) {
        this.logon = logon;
        this.password = password;
    }

    public String getLogon() {
        return logon;
    }

    public void setLogon(String logon) {
        this.logon = logon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "logon='" + logon + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
