package org.example.service.impl;

import org.example.dto.AnswerAddDto;
import org.example.dto.AnswerDto;
import org.example.entity.AnswerEntity;
import org.example.repository.AnswerRepository;
import org.example.repository.impl.AnswerRepositoryImpl;
import org.example.service.AnswerService;

import java.util.ArrayList;
import java.util.List;

public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl() {
        answerRepository = new AnswerRepositoryImpl();
    }

    @Override
    public void addAnswer(AnswerAddDto answerDto) {
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setText(answerDto.getText());
        answerEntity.setQuestionId(answerDto.getQuestionId());
        answerRepository.create(answerEntity);

    }

    @Override
    public void deactivateAnswer(int answerId) {
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setId(answerId);
        answerEntity.setActive(false);
        answerRepository.updateStatus(answerEntity);
    }
}
