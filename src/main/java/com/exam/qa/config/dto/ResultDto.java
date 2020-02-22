package com.exam.qa.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
public @Data class ResultDto
{
	private long score;
	private String email;
	private String testSeries;

}
