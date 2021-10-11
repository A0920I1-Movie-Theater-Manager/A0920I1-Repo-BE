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

    @Override
    public List<Movie> findAllMovieShowing(LocalDate today) {
        return movieRepository.findAllMovieShowing(today);
    }

    @Override
    public List<Movie> findAllMovieComingSoon(LocalDate today) {
        return movieRepository.findAllMovieComingSoon(today);
    }

    @Override
    public Movie findMovieById(long id) {
        return movieRepository.findMovieById(id);
    }

    @Override
    public List<Movie> searchMovie(String keyword, LocalDate today) {
        return movieRepository.searchMovie(keyword, today);
    }

    @Override
    public List<Movie> listTopFiveMovie() {
        return movieRepository.listTopFiveMovie();
    }
}
