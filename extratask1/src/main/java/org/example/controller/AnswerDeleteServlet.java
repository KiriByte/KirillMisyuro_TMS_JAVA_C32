package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.AnswerDto;
import org.example.service.AnswerService;
import org.example.service.impl.AnswerServiceImpl;

import java.io.IOException;

@WebServlet("/delete-answer")
public class AnswerDeleteServlet extends HttpServlet {
    private final AnswerService answerService;

    public AnswerDeleteServlet() {
        answerService = new AnswerServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("answerId"));
        answerService.deactivateAnswer(id);
        resp.sendRedirect(req.getContextPath() + "/question-details?questionId=" + req.getParameter("questionId"));
    }
}
