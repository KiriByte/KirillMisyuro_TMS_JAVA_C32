package org.example.service;

import org.example.dto.QuestionWithAnswersDto;
import org.example.dto.QuestionShortDto;

import java.util.List;

public interface QuestionService {
    List<QuestionShortDto> getQuestions();

    QuestionWithAnswersDto getQuestionByIdWithAnswers(int questionId);

    void addQuestion(QuestionShortDto question);

    void deleteQuestion(int questionId);
}
