package com.exam.interfac;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entities.QuestionEntity;
@Repository
public interface QuestionsRepository extends JpaRepository<QuestionEntity, Integer> {

}
