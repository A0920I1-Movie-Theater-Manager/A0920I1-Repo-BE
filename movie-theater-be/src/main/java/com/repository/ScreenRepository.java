package com.repository;

import com.model.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
    //TriNH- listScreen
    @Query(value = " SELECT * FROM movietheater1.screen", nativeQuery = true)
    List<Screen> findAllScreen();
    //TriNH-createScreen
    @Transactional
    @Modifying
    @Query(value = "insert into screen(name,total_seat) value (?1,?2);", nativeQuery = true)
    void createScreen(String name, int total_seat);
    //TriNH-searchNameScreen
    @Query(value = "select * from movietheater1.screen where screen.name like %?1% ",nativeQuery = true)
    List<Screen> searchName(String name);
}
