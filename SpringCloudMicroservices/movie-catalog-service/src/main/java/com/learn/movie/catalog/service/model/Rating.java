package com.learn.movie.catalog.service.model;

public class Rating {
    private String movieId;
    private int rating;

    public Rating() {
    }


    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
