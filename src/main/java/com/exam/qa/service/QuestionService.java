package com.exam.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.qa.entities.TestPaperEntity;
import com.exam.qa.repo.QuestionsRepository;

@Service
public class QuestionService
{
	@Autowired
	private QuestionsRepository questionsRepository;
	
	public List<TestPaperEntity> getQuestion()
	{
		return questionsRepository.findAll();
	}

}
