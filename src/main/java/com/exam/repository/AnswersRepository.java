package com.exam.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.entities.AnswerEntity;
@Repository
public interface AnswersRepository extends JpaRepository<AnswerEntity, Integer> {

	public List<Object[]> getScore(@Param("email") String email);

}