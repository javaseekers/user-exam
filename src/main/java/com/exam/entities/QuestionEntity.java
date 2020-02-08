package com.exam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="questions")
public @Data class QuestionEntity {
	@Id
	@Column(name="Question_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	@Column(name="Question")
	private String question;
	@Column(name="choice1")
	private String choice1;
	@Column(name="choice2")
	private String choice2;
	@Column(name="choice3")
	private String choice3;
	@Column(name="choice4")
	private String choice4;
	@Column(name="CORRECT_ANSWER")
	private String correctAnswer;
	@Column(name="TEST_SERIES")
	private String testSeries;
	@Column(name="QUESTION_MARKS")
	private int questionMarks;
	@Column(name="HINT")
	private String hint;
	
}
