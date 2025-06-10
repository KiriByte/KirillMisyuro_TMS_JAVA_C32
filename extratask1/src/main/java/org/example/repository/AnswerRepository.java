package org.example.repository;

import org.example.entity.AnswerEntity;

import java.util.List;

public interface AnswerRepository {
    boolean addAnswer(AnswerEntity answer);

    boolean deleteAnswer(AnswerEntity answer);

    boolean updateAnswer(AnswerEntity answer);

    List<AnswerEntity> getAllAnswersByQuestionId(int questionId);

    List<AnswerEntity> getAllActiveAnswersByQuestionId(int questionId);

}
