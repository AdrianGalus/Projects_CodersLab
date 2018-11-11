<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>receivedMessages</title>
</head>
<body>
    <a href="/message/sended">Sended</a>
    <ol>
        <c:forEach items="${receivedMessages}" var="message">
            <li>${message.sender.userName} ${message.theme} <a href="/message/details/${message.id}">open</a></li>
        </c:forEach>
    </ol>
    <a href="/home">Back</a>
</body>
</html>
