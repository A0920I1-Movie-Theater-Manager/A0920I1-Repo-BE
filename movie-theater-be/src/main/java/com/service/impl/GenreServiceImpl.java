package com.service.impl;

import com.repository.GenreRepository;
import com.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    GenreRepository genreRepository;

    @Override
    public void addGenreToMovie(long genre_id, long movie_id) {
        genreRepository.addGenreToMovie(genre_id, movie_id);
    }
}
