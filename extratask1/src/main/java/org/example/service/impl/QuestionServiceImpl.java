package org.example.service.impl;

import org.example.dto.QuestionDto;
import org.example.dto.QuestionShortDto;
import org.example.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    @Override
    public List<QuestionShortDto> getQuestions() {
        return List.of();
    }

    @Override
    public QuestionDto getQuestionDetails(int questionId) {
        return null;
    }

    @Override
    public void addQuestion(QuestionShortDto question) {

    }

    @Override
    public void deleteQuestion(int questionId) {

    }
}
