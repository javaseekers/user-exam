package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entities.QuestionEntity;
@Repository
public interface QuestionsRepository extends JpaRepository<QuestionEntity, Integer> {

	List<QuestionEntity> getQuestionsByTestSeries(String testSeries);
	
}
