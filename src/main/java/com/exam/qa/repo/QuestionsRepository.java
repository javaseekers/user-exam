package com.exam.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.qa.entities.TestPaperEntity;

@Repository
public interface QuestionsRepository
	extends
		JpaRepository<TestPaperEntity, Integer>
{
}
