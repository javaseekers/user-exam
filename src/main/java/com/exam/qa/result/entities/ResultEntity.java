package com.exam.qa.result.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "result", schema = "user-result")
@NoArgsConstructor
public @Data class ResultEntity implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private long score;
	@Column(name = "test_series")
	private String testSeries;
	@Column
	private String email;

	public ResultEntity(long score, String email, String testSeries)
	{
		this.score = score;
		this.email = email;
		this.testSeries = testSeries;

	}

}
