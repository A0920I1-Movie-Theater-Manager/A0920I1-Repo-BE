package com.service.impl;

import com.model.entity.Genre;
import com.repository.GenreRepository;
import com.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;
    @Override
    public List<Genre> findAllGenre() {
        return genreRepository.findAllGenre();
    }
}
