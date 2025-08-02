<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <spring:message code="register.title"/>
    </title>
</head>
<body>

<div>
    <a href="?lang=en">English</a> |
    <a href="?lang=ru">Русский</a>
</div>

<h1><spring:message code="register.title"/></h1>

<div>
    <form action="/register" method="post">

        <div>
            <spring:message code="register.username"/>
            <input type="text" name="username">
        </div>

        <div>
            <spring:message code="register.password"/>
            <input type="password" name="password">
        </div>

        <input type="submit" value="<spring:message code="button.submit"/>">

    </form>
</div>
</body>
</html>