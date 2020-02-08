package com.exam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="answers")
public @Data class AnswerEntity {
	@Id
	@Column(name="answer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int answer_Id;
	@Column(name="Email")
	private String email;
	@Column(name="answer")
	private String answer;
	@Column(name="question_id")
	private int questionId;
}
