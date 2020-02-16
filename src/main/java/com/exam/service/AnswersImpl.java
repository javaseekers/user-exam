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

		answersRepository.saveAll(answerEntity);
		AnswerEntity AnswerEntity = answerEntity.get(0);
		ScoreEntity scoreEntity = answersRepository.getScore(AnswerEntity.getEmail());
		scoreRepository.save(scoreEntity);

	}
}
