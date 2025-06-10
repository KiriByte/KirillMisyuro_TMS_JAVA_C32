package org.example.repository;

import org.example.entity.QuestionEntity;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {
    boolean addQuestion(QuestionEntity question);

    boolean deleteQuestionById(int id);

    boolean updateQuestion(QuestionEntity question);

    Optional<QuestionEntity> getQuestionById(int id);

    List<QuestionEntity> getAllQuestions();

    List<QuestionEntity> getAllActiveQuestions();

}
