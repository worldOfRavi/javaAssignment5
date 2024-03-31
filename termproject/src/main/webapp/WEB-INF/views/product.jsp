<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<head>
    <title>Product Manager</title>
  
    <style>
     body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            text-align:center;
            
            background-color: #f0f0f0;
        }
        .container {
            max-width: 800px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
        text-align:center;
            margin-bottom: 20px;
        }
        h2 {
            margin-top: 40px;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin-bottom: 10px;
        }
        form {
            display: inline;
        }
    </style>
</head>
<body>
    <h1>Manager Product/ <a href="cart">Cart</a></h1>
    
    <h2>Items</h2>
    <ul>
        <c:forEach items="${items}" var="item">
            <li>Id: ${item[0]}, Name: ${item[1]} 
                <form action="addOrUpdateProduct" method="post" style="display: inline;">
                    <input type="hidden" name="id" value="${item[0]}">
                    <input type="hidden" name="name" value="${item[1]}">
                    <input type="submit" value="Add">
                </form>
            </li>
        </c:forEach>
    </ul>
    
</body>
</html>
