package org.example.controller.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.QuestionShortDto;
import org.example.service.QuestionService;
import org.example.service.impl.QuestionServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/questions-list")
public class QuestionsServlet extends HttpServlet {

    private final QuestionService questionService;

    public QuestionsServlet() {
        questionService = new QuestionServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<QuestionShortDto> questions = questionService.getQuestions();
        req.setAttribute("questions", questions);
        req.getRequestDispatcher("questions-list.jsp").forward(req, resp);
    }


}
