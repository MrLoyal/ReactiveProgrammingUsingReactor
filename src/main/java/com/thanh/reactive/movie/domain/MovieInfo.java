package com.thanh.reactive.movie.domain;

import java.util.List;

public class MovieInfo {
    private long id;
    private String name;
    private int year;
    private List<String> cast;

    public MovieInfo(long id, String name, int year, List<String> cast) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.cast = cast;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }
}
