package com.service.impl;

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
    MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.findAllMovie();
    }

    @Override
    public Movie findMovieById(long id) {
        return movieRepository.findMovieById(id);
    }

    @Override
    public Movie getIdMovieByName(String name){
        return movieRepository.getIdMovieByName(name);
    }

    @Override
    public List<Movie> listAllMovie(String name) {
        return movieRepository.listAllMovie(name);
    }

    @Override
    public void createMovie(String title, LocalDate showing_From, LocalDate showing_To, String cast, String director, LocalDate release_Date, String rated, int running_Time,
                            String production,String trailer_Url, String content, boolean is3D, long account_Id) {
        movieRepository.createMovie(title, showing_From, showing_To, cast, director, release_Date, rated, running_Time, production, trailer_Url, content, is3D, account_Id);
    }

    @Override
    public void updateMovie(String title, LocalDate showing_From, LocalDate showing_To, String cast, String director, LocalDate release_Date, String rated, int running_Time,
                            String production, String trailer_Url, String content, boolean is3D, long account_Id, long id) {
        movieRepository.updateMovie(title, showing_From, showing_To, cast, director, release_Date, rated, running_Time, production, trailer_Url, content, is3D, account_Id, id);
    }
}
