package com.exam.result.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "score", schema = "result")
public @Data class ScoreEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "email")
	private String email;
	@Column(name = "score")
	private long score;
	@Column(name = "test_series")
	private String testSeries;
	
	public ScoreEntity() {
		
	}
 
	public ScoreEntity(long score, String email, String testSeries) {

		this.score = score;
		this.email = email;
		this.testSeries = testSeries;

	}

}
