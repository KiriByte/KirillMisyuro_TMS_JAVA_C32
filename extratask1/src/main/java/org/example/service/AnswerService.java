package org.example.service;

import org.example.dto.AnswerAddDto;

import java.util.List;

public interface AnswerService {
    void addAnswer(AnswerAddDto answerDto);

    void deleteAnswer(int answerId);
}
