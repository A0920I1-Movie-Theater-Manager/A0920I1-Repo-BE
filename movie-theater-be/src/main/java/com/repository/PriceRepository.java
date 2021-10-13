package com.repository;


import com.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    //HueHV
    @Query(value = "select * from price", nativeQuery = true)
    List<Price> listPrice();

    // HueHV
    @Transactional
    @Modifying
    @Query(value = "insert into price (time, day, is3D, price) values (?1, ?2, ?3, ?4) ", nativeQuery = true)
    void addPriceMovie(String time, String day, boolean is3D,double price);
}
