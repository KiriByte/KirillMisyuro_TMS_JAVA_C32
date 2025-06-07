package org.example.service;

import org.example.dto.QuestionDto;
import org.example.dto.QuestionShortDto;

import java.util.List;

public interface QuestionService {
    List<QuestionShortDto> getQuestions();

    QuestionDto getQuestionDetails(int questionId);

    void addQuestion(QuestionShortDto question);

    void deleteQuestion(int questionId);
}
