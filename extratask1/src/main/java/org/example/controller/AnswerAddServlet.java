package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.AnswerAddDto;
import org.example.dto.AnswerDto;
import org.example.service.AnswerService;
import org.example.service.impl.AnswerServiceImpl;

import java.io.IOException;

@WebServlet("/add-answer")
public class AnswerAddServlet extends HttpServlet {

    private final AnswerService answerService;

    public AnswerAddServlet() {
        answerService = new AnswerServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("answerText");
        int questionId = Integer.parseInt(req.getParameter("questionId"));
        AnswerAddDto answerDto = new AnswerAddDto();
        answerDto.setText(text);
        answerDto.setQuestionId(questionId);
        answerService.addAnswer(answerDto);
        resp.sendRedirect(req.getContextPath() + "/question-details?questionId=" + req.getParameter("questionId"));
    }
}
