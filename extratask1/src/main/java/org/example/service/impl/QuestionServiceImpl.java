package org.example.service.impl;

import org.example.dto.AnswerDto;
import org.example.dto.QuestionWithAnswersDto;
import org.example.dto.QuestionShortDto;
import org.example.entity.AnswerEntity;
import org.example.entity.QuestionEntity;
import org.example.repository.impl.AnswerRepositoryImpl;
import org.example.repository.impl.QuestionRepositoryImpl;
import org.example.service.QuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepositoryImpl questionRepository;
    private final AnswerRepositoryImpl answerRepository;

    public QuestionServiceImpl() {
        questionRepository = new QuestionRepositoryImpl();
        answerRepository = new AnswerRepositoryImpl();
    }

    @Override
    public List<QuestionShortDto> getQuestions() {
        List<QuestionShortDto> questions = new ArrayList<>();
        questionRepository.getAllActiveQuestions().forEach(question -> {
            QuestionShortDto questionDto = new QuestionShortDto();
            questionDto.setId(question.getId());
            questionDto.setText(question.getText());
            questions.add(questionDto);
        });
        return questions;
    }

    @Override
    public QuestionWithAnswersDto getQuestionByIdWithAnswers(int questionId) {
        QuestionWithAnswersDto dto = new QuestionWithAnswersDto();
        Optional<QuestionEntity> question = questionRepository.getQuestionById(questionId);
        if (question.isPresent()) {
            dto.setId(question.get().getId());
            dto.setText(question.get().getText());
            List<AnswerEntity> answers = answerRepository.getAllActiveAnswersByQuestionId(questionId);

            List<AnswerDto> answerDtos = answers.stream()
                    .map(answer -> {
                        AnswerDto answerDto = new AnswerDto();
                        answerDto.setId(answer.getId());
                        answerDto.setText(answer.getText());
                        return answerDto;
                    }).collect(Collectors.toList());
            dto.setAnswers(answerDtos);
        }
        return dto;
    }

    @Override
    public void addQuestion(QuestionShortDto question) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setText(question.getText());
        questionEntity.setActive(true);
        questionRepository.addQuestion(questionEntity);
    }

    @Override
    public void deleteQuestion(int questionId) {
        questionRepository.deleteQuestionById(questionId);
    }
}
