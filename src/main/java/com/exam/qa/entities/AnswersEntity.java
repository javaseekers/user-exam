package com.exam.qa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "answers", schema = "examquestions")
public @Data class AnswersEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	/*
	 * for both sql and my sql it will work with out changing the code if but it
	 * will hibernate specific if use IDENTITY it will work but if you switch
	 * one data base to other data base it will not work but it will support
	 * muliple entity supports like other than hibernate
	 */
	private Integer id;
	private String answer;
	private String email;
	@Column(name = "question_id")
	private Integer questionId;

}
