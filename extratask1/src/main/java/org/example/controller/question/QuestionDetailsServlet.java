package org.example.controller.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.QuestionWithAnswersDto;
import org.example.service.QuestionService;
import org.example.service.impl.QuestionServiceImpl;

import java.io.IOException;


@WebServlet("/question-details")
public class QuestionDetailsServlet extends HttpServlet {

    private final QuestionService questionService;

    public QuestionDetailsServlet() {
        questionService = new QuestionServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var questionId = Integer.parseInt(req.getParameter("questionId"));
        QuestionWithAnswersDto questionWithAnswersDto = questionService.getQuestionByIdWithAnswers(questionId);
        req.setAttribute("question", questionWithAnswersDto);
        req.getRequestDispatcher("question-details.jsp").forward(req, resp);
    }
}
