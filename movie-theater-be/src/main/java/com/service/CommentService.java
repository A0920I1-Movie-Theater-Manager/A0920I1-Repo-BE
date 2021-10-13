package com.service;

import com.model.entity.Comment;
import com.model.entity.Movie;

import java.util.List;

public interface CommentService {
    List<Comment> findAllCommentByMovieId(long id);
    void addNewComment(String content, Movie movie);
}
