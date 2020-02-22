package com.exam.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.qa.config.dto.ResultDto;
import com.exam.qa.entities.AnswersEntity;
import com.exam.qa.entities.UserExamBo;
import com.exam.qa.repo.AnswersRepository;
import com.exam.qa.result.entities.ResultEntity;
import com.exam.qa.result.repo.ResultRepository;

@Service
public class ExamService
{
	@Autowired
	AnswersRepository answersRepository;

	@Autowired
	ResultRepository resultRepository;

	public void examSubmit(AnswersEntity answersEntity)
	{
		answersRepository.save(answersEntity);
	}

	public void examSubmit(UserExamBo userExamBo)
	{
		List<AnswersEntity> userList = userExamBo.getAnswerList();

		answersRepository.saveAll(userList);

		ResultDto resultEntityDto = (ResultDto) answersRepository
			.calCulateResult(userList.get(0).getEmail()).get(0)[0];

		ResultEntity resultEntity = new ResultEntity();

		resultEntity.setEmail(resultEntityDto.getEmail());
		resultEntity.setScore(resultEntityDto.getScore());
		resultEntity.setTestSeries(resultEntityDto.getTestSeries());

		resultRepository.save(resultEntity);
	}

}
