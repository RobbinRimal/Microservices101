package com.example.MovieInfoService.model;

public class Movie {
 private String name;
 private String rating;

    public Movie() {
    }

    public Movie(String name, String rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
