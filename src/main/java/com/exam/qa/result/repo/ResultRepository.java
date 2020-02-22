package com.exam.qa.result.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.qa.config.dto.ResultDto;
import com.exam.qa.result.entities.ResultEntity;
@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Integer>
{
	public ResultDto calCulateResult(String email);
		
}
