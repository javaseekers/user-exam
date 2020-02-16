package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entities.AnswerEntity;
import com.exam.service.AnswersImpl;

@RestController
@RequestMapping("answer/v1")
public class AnswersController {
	@Autowired
	AnswersImpl AnswersService;
	
	@PostMapping("/setAnswers")
	public ResponseEntity<String> setAnswers(@RequestBody List<AnswerEntity> answerEntity) {
		AnswersService.setAnswers(answerEntity);
		return ResponseEntity.ok().body("saved successfully!!! ");	
	}

}
