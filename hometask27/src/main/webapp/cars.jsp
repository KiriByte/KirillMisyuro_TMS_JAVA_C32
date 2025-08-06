<%@ page import="model.Car" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Car List</title>
</head>
<body>
<h1>Car List</h1>

<h2>Using JSP Scriptlet</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Model</th>
        <th>Price</th>
    </tr>
    <%
        List<Car> cars = (List<Car>) request.getAttribute("cars");
        if (cars != null) {
            for (Car car : cars) {
    %>
    <tr>
        <td><%= car.getId() %>
        </td>
        <td><%= car.getModel() %>
        </td>
        <td><%= car.getPrice() %>
        </td>
    </tr>
    <% }
    }%>
</table>

<h2>Using JSTL</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Model</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.model}</td>
            <td>${car.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>