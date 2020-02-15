package com.exam.qa.entities;

import java.util.List;

import lombok.Data;

public @Data class UserExamBo
{
	private String testSeries;
	private List<AnswersEntity> answerList;
}
