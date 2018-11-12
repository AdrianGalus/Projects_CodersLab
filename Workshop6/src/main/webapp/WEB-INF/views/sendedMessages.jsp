<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sendedMessages</title>
</head>
<body>
    <a href="/message/received">Received</a>
    <ol>
        <c:forEach items="${sendedMessages}" var="message">
            <li>${message.receiver.userName} ${message.read} ${message.theme}
                <a href="/message/details/${message.id}">open</a></li>
        </c:forEach>
    </ol>
    <a href="/home">Back</a>
</body>
</html>
