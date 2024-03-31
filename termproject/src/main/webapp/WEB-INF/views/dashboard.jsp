<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
<h1>This is a dashboard page</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Password</th>
        </tr>
        <c:forEach var="client" items="${clients}">
            <tr>
                <td>${client.id}</td>
                <td>${client.name}</td>
                <td>${client.password}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>