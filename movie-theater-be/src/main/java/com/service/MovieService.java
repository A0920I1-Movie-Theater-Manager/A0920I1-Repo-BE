package com.service;

import com.model.entity.Movie;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {
    List<Movie> findAllMovieShowing(LocalDate today);
    List<Movie> findAllMovieComingSoon(LocalDate today);
    Movie findMovieById(long id);
}
