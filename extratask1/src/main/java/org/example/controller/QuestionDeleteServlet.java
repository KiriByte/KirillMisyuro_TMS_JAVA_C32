package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.QuestionService;
import org.example.service.impl.QuestionServiceImpl;

import java.io.IOException;

@WebServlet("/delete-question")
public class QuestionDeleteServlet extends HttpServlet {

    public final QuestionService questionService;

    public QuestionDeleteServlet() {
        questionService = new QuestionServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("questionId"));
        questionService.deleteQuestion(id);
        resp.sendRedirect("questions-list");
    }
}
