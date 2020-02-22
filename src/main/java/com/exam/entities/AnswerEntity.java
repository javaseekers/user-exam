package com.exam.entities;

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


import com.exam.dto.ResultDto;

import lombok.Data;

@Entity
@Table(name="answers" , schema="exam")
@SqlResultSetMapping(name = "resultScore", classes = {
@ConstructorResult(targetClass = ResultDto.class, columns = {
@ColumnResult(name = "score", type = Long.class),
@ColumnResult(name = "email"), @ColumnResult(name = "testSeries")})})
@NamedNativeQuery(name = "AnswerEntity.getScore", query = "select sum(q.question_marks) as score, a.email as email,q.test_series as testSeries from exam.questions q join exam.answers a on q.question_id=a.question_id and q.correct_answer=a.answer where a.email= :email", resultSetMapping = "resultScore")

public @Data class AnswerEntity {
	@Id
	@Column(name="answer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int answer_Id;
	@Column(name="Email")
	private String email;
	@Column(name="answer")
	private String answer;
	@Column(name="question_id")
	private int questionId;
}
