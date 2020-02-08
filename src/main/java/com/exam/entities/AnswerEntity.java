package com.exam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="answers")
public @Data class AnswerEntity {
	@Id
	@Column(name="ANSWER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int answer_Id;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ANSWER")
	private String answer;
	@OneToOne
	@JoinColumn(name="QUESTION_ID")
	private QuestionEntity QuestionEntity;
}
