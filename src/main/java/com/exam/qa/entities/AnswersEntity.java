package com.exam.qa.entities;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.exam.qa.config.dto.ResultDto;

import lombok.Data;

@Entity
@Table(name = "answers", schema = "examquestions")
@SqlResultSetMapping(name = "resultScore", classes = {
	@ConstructorResult(targetClass = ResultDto.class, columns = {
		@ColumnResult(name = "score", type = Long.class),
		@ColumnResult(name = "email"), @ColumnResult(name = "testSeries")})})
@NamedNativeQuery(name = "AnswersEntity.calCulateResult", query = "select sum(t.question_marks) as score, a.email as email,t.test_series as testSeries from examquestions.testpaper t join examquestions.answers a on t.question_id=a.question_id and t.answer=a.answer where a.email= :email", resultSetMapping = "resultScore")
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
