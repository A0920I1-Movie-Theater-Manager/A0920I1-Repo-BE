package com.service;

import com.model.dto.TopFiveMovieDTO;
import com.model.entity.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {
//    TuHC
    List<Movie> findAllMovieShowing(LocalDate today);
    List<Movie> findAllMovieComingSoon(LocalDate today);
    Movie findMovieById(long id);
    List<Movie> searchMovie(String keyword, LocalDate today);
    List<Movie> listTopFiveMovie();
    List<Movie> findAllMovieShowingAndComingSoon();
}
