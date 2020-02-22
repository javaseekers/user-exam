package com.exam.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.qa.entities.AnswersEntity;

@Repository
public interface AnswersRepository
	extends
		JpaRepository<AnswersEntity, Integer>
{
	public List<Object[]> calCulateResult(@Param("email") String email);
}
