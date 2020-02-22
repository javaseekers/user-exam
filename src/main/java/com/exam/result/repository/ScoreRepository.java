package com.exam.result.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.result.entity.ScoreEntity;


@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, Integer> {

	ScoreEntity getByEmail(String email);

}
