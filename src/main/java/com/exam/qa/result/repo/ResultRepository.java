package com.exam.qa.result.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.qa.result.entities.ResultEntity;
public interface ResultRepository extends JpaRepository<ResultEntity, Integer>
{

}
