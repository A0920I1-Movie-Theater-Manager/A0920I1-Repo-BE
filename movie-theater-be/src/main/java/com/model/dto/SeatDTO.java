package com.model.dto;

//TuHC
public class SeatDTO {
    private String movieId;
    private String showtimeId;

    public SeatDTO(String movieId, String showtimeId) {
        this.movieId = movieId;
        this.showtimeId = showtimeId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(String showtimeId) {
        this.showtimeId = showtimeId;
    }
}
