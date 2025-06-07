package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.QuestionShortDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/questions-list")
public class QuestionsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<QuestionShortDto> questions = new ArrayList<>();
        questions.add(new QuestionShortDto(1, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        questions.add(new QuestionShortDto(2, "2"));
        questions.add(new QuestionShortDto(3, "3"));
        questions.add(new QuestionShortDto(4, "4"));
        req.setAttribute("questions", questions);
        req.getRequestDispatcher("questions-list.jsp").forward(req, resp);
    }


}
