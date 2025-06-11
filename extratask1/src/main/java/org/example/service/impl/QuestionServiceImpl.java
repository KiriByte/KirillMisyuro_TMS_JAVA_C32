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
        questionRepository.findAllActive().forEach(question -> {
            QuestionShortDto questionDto = new QuestionShortDto();
            questionDto.setId(question.getId());
            questionDto.setText(question.getText());
            questions.add(questionDto);
        });
        return questions;
    }

    @Override
    public QuestionWithAnswersDto getQuestionByIdWithAnswers(int questionId) {
        QuestionWithAnswersDto questionDto = new QuestionWithAnswersDto();
        Optional<QuestionEntity> question = questionRepository.findById(questionId);
        if (question.isPresent()) {
            questionDto.setId(question.get().getId());
            questionDto.setText(question.get().getText());

            List<AnswerEntity> answers = answerRepository.getAllActiveAnswersByQuestionId(questionId);
            List<AnswerDto> answerDtos = answers.stream()
                    .map(answer -> {
                        AnswerDto answerDto = new AnswerDto();
                        answerDto.setId(answer.getId());
                        answerDto.setText(answer.getText());
                        return answerDto;
                    }).collect(Collectors.toList());
            questionDto.setAnswers(answerDtos);
        }
        return questionDto;
    }

    @Override
    public boolean addQuestion(QuestionShortDto question) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setText(question.getText());
        questionEntity.setActive(true);
        QuestionEntity entity = questionRepository.create(questionEntity);
        return entity != null;
    }

    @Override
    public void deleteQuestion(int questionId) {
        Optional<QuestionEntity> question = questionRepository.findById(questionId);
        if (question.isPresent()) {
            question.get().setActive(false);
            questionRepository.updateStatus(question.get());
        }
    }
}
