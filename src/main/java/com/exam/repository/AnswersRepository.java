package com.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.entities.AnswerEntity;
import com.exam.result.entity.ScoreEntity;
@Repository
public interface AnswersRepository extends JpaRepository<AnswerEntity, Integer> {

	@Query("select new com.exam.result.entity.ScoreEntity( sum(q.questionMarks) as score, a.email  as email,q.testSeries as testSeries)from QuestionEntity q,AnswerEntity a where a.email= :email and q.questionId=a.questionId and a.answer=q.correctAnswer")
	public ScoreEntity getScore(@Param("email") String email);

}