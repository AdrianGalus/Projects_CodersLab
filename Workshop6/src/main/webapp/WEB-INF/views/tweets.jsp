<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tweets</title>
</head>
<body>
    All your tweets!
    <ol>
        <c:forEach items="${tweets}" var="tweet">
            <li>${tweet}</li>
        </c:forEach>
    </ol>
    <a href="/home">Back</a>
</body>
</html>
