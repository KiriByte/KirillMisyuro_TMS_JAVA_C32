<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Вопрос #${question.id}</title>
    <link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
</head>
<body>
<main class="container">
    <article>
        <h1 class="text-center">${question.text}</h1>
        <form method="post" action="add-answer">
            <input type="hidden" name="questionId" value="${question.id}">
            <div class="flex">
                <label>
                    Текст ответа:
                    <input type="text" name="answerText" placeholder="Введите текст ответа" required>
                </label>
                <button type="submit" class="outline">Добавить</button>
            </div>
        </form>
        <h3>Варианты ответов:</h3>
        <c:forEach var="answer" items="${question.answers}">

            <div class="grid">
                <div>${answer.text}</div>
                <div>
                    <form method="post" action="delete-answer" style="margin: 0;">
                        <input type="hidden" name="questionId" value="${question.id}">
                        <input type="hidden" name="answerId" value="${answer.id}">
                        <button type="submit" class="secondary">Удалить</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </article>
</main>
</body>
</html>
