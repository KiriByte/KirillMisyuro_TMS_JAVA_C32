package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.AnswerDto;
import org.example.dto.QuestionDetailsDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/question-details")
public class QuestionDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var question = new QuestionDetailsDto(1, "Test title", List.of(
                new AnswerDto(1, "Test answer 1"),
                new AnswerDto(2, "Test answer 2"),
                new AnswerDto(3, "Test answer 3"),
                new AnswerDto(4, "Test answer 4")
        ));
        req.setAttribute("question", question);
        req.getRequestDispatcher("question-details.jsp").forward(req, resp);
    }
}
