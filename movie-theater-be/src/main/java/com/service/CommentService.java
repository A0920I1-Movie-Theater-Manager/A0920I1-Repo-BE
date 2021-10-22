package com.service;

import com.model.entity.Comment;
import com.model.entity.Movie;

import java.util.List;

public interface CommentService {
//    TuHC
    List<Comment> findAllCommentByMovieId(long id);
    void addNewComment(String content, long account, long movie, int seen);
}
