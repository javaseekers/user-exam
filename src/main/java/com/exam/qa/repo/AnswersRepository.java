package com.exam.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.qa.entities.AnswersEntity;
import com.exam.qa.result.entities.ResultEntity;

@Repository
public interface AnswersRepository
	extends
		JpaRepository<AnswersEntity, Integer>
{
	@Query("select new com.exam.qa.result.entities.ResultEntity(count(a.email) as score, a.email as email) from TestPaperEntity t join AnswersEntity a on t.questionId=a.questionId and t.answer=a.answer where a.email= :email")
	public ResultEntity calCulateResult(@Param("email") String email);
}
