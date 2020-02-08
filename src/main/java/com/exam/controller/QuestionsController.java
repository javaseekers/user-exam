package com.exam.controller;

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

import com.exam.entities.QuestionEntity;
import com.exam.exception.ResourceNotFoundException;
import com.exam.service.QuestionsImpl;

@RestController
@RequestMapping("question/v1")
public class QuestionsController {
	@Autowired
	QuestionsImpl questionsImpl;

	@GetMapping("questions")
	public ResponseEntity<List<QuestionEntity>> getQuestions()
	{
		return ResponseEntity.ok().body(questionsImpl.getQuestions());
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveQuestion(@RequestParam("file") MultipartFile excelData)
			throws IOException 
	{
		questionsImpl.saveQuestions(excelData);
		return ResponseEntity.ok().body("Succesfully inserted data");
	}
	
	@GetMapping("questions/{testSeries}")
	public ResponseEntity<List<QuestionEntity>> getQuestionsBySeries(@PathVariable String testSeries)
			throws ResourceNotFoundException {
		return ResponseEntity.ok().body(questionsImpl.getQuestionsBySeries(testSeries));

	}

}
