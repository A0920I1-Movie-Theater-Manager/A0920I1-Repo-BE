package com.repository;

import com.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
