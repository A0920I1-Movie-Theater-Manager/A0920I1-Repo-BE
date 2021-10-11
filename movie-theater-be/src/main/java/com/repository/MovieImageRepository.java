package com.repository;

import com.model.entity.MovieImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {
}
