package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.QuestionEntity;
import com.exam.interfac.QuestionsRepository;
@Service
public class QuestionsImpl{
	@Autowired
	QuestionsRepository QuestionsRepository;

	public List<QuestionEntity> getQuestions() {
		System.out.print("&&&&&&&&&&&&&77 "+QuestionsRepository.findAll());
		return QuestionsRepository.findAll();
	}

}
