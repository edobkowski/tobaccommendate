package com.tobaccode.tobaccommendate.entities;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;


public class TobbacoRatingPk implements Serializable {

    @ManyToOne
    private Tobacco tobacco;

    @Column(insertable = false, updatable = false, nullable = false)
    private String username;

    public TobbacoRatingPk() {
    }

    public TobbacoRatingPk(Tobacco tobacco, String username) {
        this.tobacco = tobacco;
        this.username = username;
    }

    public Tobacco getTobacco() {
        return tobacco;
    }

    public void setTobacco(Tobacco tobacco) {
        this.tobacco = tobacco;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TobbacoRatingPk that = (TobbacoRatingPk) o;
        return Objects.equals(tobacco, that.tobacco) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tobacco, username);
    }
}
