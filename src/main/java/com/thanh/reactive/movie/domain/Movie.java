package com.thanh.reactive.movie.domain;

import java.util.List;

public class Movie {

    private long id;

    private MovieInfo movieInfo;

    private List<Review> reviewList;

    private Revenue revenue;

    @Override
    public String toString() {
        return id + "-" + (movieInfo != null ? movieInfo.getName() : "NoName");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public Revenue getRevenue() {
        return revenue;
    }

    public void setRevenue(Revenue revenue) {
        this.revenue = revenue;
    }
}
