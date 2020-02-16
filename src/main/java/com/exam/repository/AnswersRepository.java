package com.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.entities.AnswerEntity;
@Repository
public interface AnswersRepository extends JpaRepository<AnswerEntity, Integer> {

	@Query("select sum(q.questionMarks) from QuestionEntity q,AnswerEntity a where a.email= :email and q.questionId=a.questionId and a.answer=q.correctAnswer")
	public int getScore(@Param("email") String email);

}