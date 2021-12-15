<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>My current cars</title>
</head>
<body>
<%@include file="../../header.jsp"%>
<h1 class="table_dark">My current cars:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>ID</th>
        <th>Model</th>
        <th>Manufacturer name</th>
        <th>Manufacturer country</th>
    </tr>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>
                <c:out value="${car.id}"/>
            </td>
            <td>
                <c:out value="${car.model}"/>
            </td>
            <td>
                <c:out value="${car.manufacturer.name}"/>
            </td>
            <td>
                <c:out value="${car.manufacturer.country}"/>
            </td>
        </tr>
    </c:forEach>
    <tr><td><a href="${pageContext.request.contextPath}/index"><button type="submit">
        Back to index</button></a></td></tr>
</table>
</body>
</html>
