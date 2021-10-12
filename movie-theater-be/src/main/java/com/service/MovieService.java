package com.service;

import com.model.entity.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {
    List<Movie> getAllMovie();
    Movie findMovieById(long id);
    List<Movie> listAllMovie(String name);
    Movie getIdMovieByName(String name);
    void createMovie(String title, LocalDate showing_From, LocalDate showing_To, String cast, String director, LocalDate release_Date, String rated, int running_Time,
                     String production,String trailer_Url, String content, boolean is3D, long account_Id);
    void updateMovie(String title, LocalDate showing_From, LocalDate showing_To, String cast, String director, LocalDate release_Date, String rated, int running_Time,
                     String production, String trailer_Url, String content, boolean is3D, long account_Id, long id);
}
