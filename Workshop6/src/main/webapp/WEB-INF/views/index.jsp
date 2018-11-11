<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <c:if test="${not empty user}">
        Hello ${user.userName}! <a href="/user/logout">Logout</a>
        <br/>
        <a href="tweet/create">New tweet</a>
        <br/>

    </c:if>
    <c:if test="${empty user}">
        Hello! <a href="/user/login">Login</a> <a href="/user/registration">Registration</a>
    </c:if>
    <br/>
    <ol>
        <c:forEach items="${tweets}" var="tweet">
            <li>${tweet}</li>
        </c:forEach>
    </ol>
</body>
</html>
