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
        <!-- Название вопроса -->
        <h1 class="text-center">${question.title}</h1>

        <!-- Форма для добавления нового ответа -->
        <form method="post" action="<c:url value='/add-answer'/>">
            <input type="hidden" name="questionId" value="${question.id}">
            <div class="flex">
                <label style="flex-grow: 1;">
                    Текст ответа:
                    <input type="text" name="answerText" placeholder="Введите текст ответа" required>
                </label>
                <button type="submit" class="outline">Добавить</button>
            </div>
        </form>

        <!-- Список ответов -->
        <h3>Варианты ответов:</h3>
        <ul>
            <c:forEach var="answer" items="${question.answers}">
                <li>
                    <div class="grid">
                        <div>${answer.answer}</div>
                        <div>
                            <form method="post" action="<c:url value='/delete-answer'/>" style="margin: 0;">
                                <input type="hidden" name="questionId" value="${question.id}">
                                <input type="hidden" name="answerId" value="${answer.id}">
                                <button type="submit" class="secondary">Удалить</button>
                            </form>
                        </div>

                    </div>
                </li>
            </c:forEach>
        </ul>
    </article>
</main>
</body>
</html>
