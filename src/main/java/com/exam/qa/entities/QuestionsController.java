package com.exam.qa.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.qa.service.QuestionService;

@RestController
@RequestMapping("questionsApi/v1")
public class QuestionsController
{
	@Autowired
	private QuestionService questionService;

	@GetMapping("questions")
	public ResponseEntity<List<TestPaperEntity>> getQuestions()
	{

		return ResponseEntity.ok().body(questionService.getQuestion());
	}

}
