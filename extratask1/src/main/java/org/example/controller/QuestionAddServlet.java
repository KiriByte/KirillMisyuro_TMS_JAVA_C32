package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.QuestionShortDto;
import org.example.service.QuestionService;
import org.example.service.impl.QuestionServiceImpl;

import java.io.IOException;

@WebServlet("/add-question")
public class QuestionAddServlet extends HttpServlet {

    public final QuestionService questionService;

    public QuestionAddServlet() {
        questionService = new QuestionServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("questionText");
        QuestionShortDto questionShortDto = new QuestionShortDto();
        questionShortDto.setText(text);
        questionService.addQuestion(questionShortDto);
        resp.sendRedirect("questions-list");
    }
}
