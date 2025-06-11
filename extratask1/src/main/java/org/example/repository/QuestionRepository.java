package org.example.repository;

import org.example.entity.QuestionEntity;

import java.util.List;


public interface QuestionRepository extends CrudRepository<QuestionEntity> {

    boolean updateStatus(QuestionEntity question);

    List<QuestionEntity> findAllActive();

}
