<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Опросы</title>
    <link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
</head>
<body>
<main class="container">
    <div>
        <h1>Управление опросами</h1>

        <div>
            <h2>Создать новый вопрос</h2>
            <form method="post" action="add-question">
                <label>
                    Текст вопроса
                    <textarea name="questionText" required></textarea>
                </label>
                <button type="submit">Создать</button>
            </form>
        </div>


        <c:choose>
            <c:when test="${empty questions}">
                <h2>Нет доступных вопросов</h2>
            </c:when>
            <c:otherwise>
                <div>
                    <h2>Список вопросов</h2>

                    <table role="grid">
                        <tbody>
                        <c:forEach var="question" items="${questions}">
                            <tr>
                                <td>${question.text}</td>
                                <td>
                                    <div class="action-buttons">
                                        <form method="get" action="question-details">
                                            <input type="hidden" name="questionId" value="${question.id}">
                                            <button type="submit" class="secondary">Редактировать</button>
                                        </form>
                                        <form method="post" action="delete-question">
                                            <input type="hidden" name="questionId" value="${question.id}">
                                            <button type="submit" class="contrast">Удалить
                                            </button>
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>


    </div>
</main>
</body>
</html>