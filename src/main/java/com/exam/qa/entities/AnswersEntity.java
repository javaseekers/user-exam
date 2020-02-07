package com.exam.qa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "answers")
public @Data class AnswersEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer testSeries;
	private String answer;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id", referencedColumnName = "question_id")
	private TestPaperEntity testPaper;

}
