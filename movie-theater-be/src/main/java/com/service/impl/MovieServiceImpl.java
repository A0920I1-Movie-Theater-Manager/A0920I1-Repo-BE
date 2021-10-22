package com.service.impl;

import com.model.dto.TopFiveMovieDTO;
import com.model.entity.Movie;
import com.repository.MovieRepository;
import com.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    //TuHC - lay phim dang chieu
    @Override
    public List<Movie> findAllMovieShowing(LocalDate today) {
        return movieRepository.findAllMovieShowing(today);
    }

    //TuHC - lay phim sap chieu
    @Override
    public List<Movie> findAllMovieComingSoon(LocalDate today) {
        return movieRepository.findAllMovieComingSoon(today);
    }

    //TuHc - lay phim theo id
    @Override
    public Movie findMovieById(long id) {
        return movieRepository.findMovieById(id);
    }

    //TuHC - tim kiem phim
    @Override
    public List<Movie> searchMovie(String keyword, LocalDate today) {
        return movieRepository.searchMovie(keyword, today);
    }

    //TuHC - lay top 5 phim
    @Override
    public List<Movie> listTopFiveMovie() {
        return movieRepository.listTopFiveMovie();
    }

    //TuHC - lay phim dang chieu va sap chieu
    @Override
    public List<Movie> findAllMovieShowingAndComingSoon() {
        return movieRepository.findAllMovieShowingAndComingSoon();
    }
}
