package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDetailsDto {
    private int id;
    private String title;
    private List<AnswerDto> answers;
}
