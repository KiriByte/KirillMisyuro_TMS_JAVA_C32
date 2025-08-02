<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Успех</title>
</head>
<body>
<h1><%= request.getAttribute("message") %>
</h1>
<a href="/register"><spring:message code="button.back"/></a>
</body>
</html>