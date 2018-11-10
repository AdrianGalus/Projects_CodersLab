<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <c:if test="${not empty user}">
        Hello ${user.userName}! <a href="/user/logout">Logout</a>
    </c:if>
    <c:if test="${empty user}">
        Hello! <a href="/user/login">Login</a> <a href="/user/registration">Registration</a>
    </c:if>
</body>
</html>
