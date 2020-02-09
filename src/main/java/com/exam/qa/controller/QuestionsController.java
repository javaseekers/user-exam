package com.exam.qa.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exam.qa.entities.TestPaperEntity;
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
	@PostMapping("insert")
	public ResponseEntity<String> uploadQuestions(
		@RequestParam("file") MultipartFile file) throws IOException
	{
		questionService.uploadQuestions(file);
		
		return ResponseEntity.ok().body("Questions uploaded successfully");
	}
	
	@GetMapping("questions/{series}")
	public ResponseEntity<List<TestPaperEntity>> getQuestionsBySeries(
		@PathVariable("series") String series)
	{
		return ResponseEntity.ok()
			.body(questionService.getQuestionsBySeries(series));
	}
}
