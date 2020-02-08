package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entities.QuestionEntity;
import com.exam.service.QuestionsImpl;

@RestController
@RequestMapping("question/v1")
public class QuestionsController {
	@Autowired
	QuestionsImpl QuestionsImpl;

	@GetMapping("quesions")
	public ResponseEntity<List<QuestionEntity>> getQuestions() {
		return ResponseEntity.ok().body(QuestionsImpl.getQuestions());

	}
}
