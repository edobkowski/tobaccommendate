package com.tobaccode.tobaccommendate.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ratings")
public class TobaccoRating {

    @EmbeddedId
    private TobbacoRatingPk pk;

    @Column(nullable = false)
    private Integer rating;

    @Column
    private String comment;

    public TobaccoRating() {
    }

    public TobaccoRating(TobbacoRatingPk pk, Integer rating, String comment) {
        this.pk = pk;
        this.rating = rating;
        this.comment = comment;
    }

    public TobbacoRatingPk getPk() {
        return pk;
    }

    public void setPk(TobbacoRatingPk pk) {
        this.pk = pk;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TobaccoRating that = (TobaccoRating) o;
        return Objects.equals(pk, that.pk) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, rating, comment);
    }

    @Override
    public String toString() {
        return "TobaccoRating{" +
                "pk=" + pk +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
