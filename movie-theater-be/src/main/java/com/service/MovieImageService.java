package com.service;

import com.model.entity.MovieImage;


import java.util.List;

public interface MovieImageService {
    // HueHV
    void addImageByIdMovie(String image_url, long id);

    //HueHV
    List<MovieImage> listImageMovieById(long movie_id);
}
