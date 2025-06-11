package org.example.repository;

import org.example.entity.AnswerEntity;

import java.util.List;

public interface AnswerRepository extends CrudRepository<AnswerEntity> {

    boolean updateStatus(AnswerEntity answerEntity);

    List<AnswerEntity> findAllActiveByQuestionId(long questionId);
}
