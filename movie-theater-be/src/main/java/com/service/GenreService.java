package com.service;

import com.model.entity.Genre;

import java.util.List;

public interface GenreService {
    void addGenreToMovie(long genre_id, long movie_id);

    List<Genre> findAll();
}
