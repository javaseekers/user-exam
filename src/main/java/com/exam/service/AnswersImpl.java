package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dto.ResultDto;
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
		List<Object[]> listObj = answersRepository.getScore(AnswerEntity.getEmail());
		ResultDto localResultDto = (ResultDto) listObj.get(0)[0];
		ScoreEntity scoreEntity = new ScoreEntity();
		scoreEntity.setScore(localResultDto.getScore());
		scoreEntity.setEmail(localResultDto.getEmail());
		scoreEntity.setTestSeries(localResultDto.getTestSeries());
		scoreRepository.save(scoreEntity);

	}
}
