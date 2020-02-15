package com.exam.qa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.qa.entities.UserExamBo;
import com.exam.qa.service.ExamService;

@RestController
@RequestMapping("userExamApi/v1")
public class ExamController
{
	@Autowired
	ExamService examService;

	@PostMapping("submit")
	public ResponseEntity<String> examSubmit(
		@RequestBody UserExamBo userExamBo)
	{
		examService.examSubmit(userExamBo);

		return ResponseEntity.ok().body("Exam submitted Sucessfully");
	}

}
