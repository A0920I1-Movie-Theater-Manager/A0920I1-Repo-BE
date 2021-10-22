package com.repository;


import com.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    //    TuHC - lay comment cho 1 bo phim
    @Query(value = "SELECT * FROM movietheater.comment " +
            "where movie_id = :id", nativeQuery = true)
    List<Comment> findAllCommentByMovieId(@Param("id") long id);

//    TuHC - them moi 1 comment
    @Query(value = "INSERT INTO `movietheater`.`comment` (`content`, `account_id`, `movie_id`, `seen`) " +
            "VALUES (:content, :accountId, :movieId, :seen)", nativeQuery = true)
    void addNewComment(@Param("content") String content,@Param("accountId") long accountId,
                       @Param("movieId") long movieId, @Param("seen") int seen);

}
