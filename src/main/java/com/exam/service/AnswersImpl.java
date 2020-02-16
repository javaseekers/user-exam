package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.AnswerEntity;
import com.exam.repository.AnswersRepository;
import com.exam.result.entity.ScoreEntity;
import com.exam.result.repository.ScoreRepository;

@Service
public class AnswersImpl {
	@Autowired
	AnswersRepository answersRepository;
	@Autowired
	ScoreRepository scoreRepository;

	public void setAnswers(List<AnswerEntity> answerEntity) {
		int localScore = 0;
		answersRepository.saveAll(answerEntity);
		AnswerEntity AnswerEntity = answerEntity.get(0);
		localScore = answersRepository.getScore(AnswerEntity.getEmail());
		System.out.println("&&&&&&&&&&&&&&&       "+localScore);
		
		  ScoreEntity scoreEntity = new ScoreEntity();
		  scoreEntity.setEmail(AnswerEntity.getEmail());
		  scoreEntity.setScore(localScore); scoreEntity.setTestSeries("Java");
		  scoreRepository.save(scoreEntity);
		 
	}
}
