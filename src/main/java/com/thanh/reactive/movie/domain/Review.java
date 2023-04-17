package com.thanh.reactive.movie.domain;

public class Review {
    private long id;
    private String comment;
    private float rating;

    public Review(long id, String comment, float rating) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
