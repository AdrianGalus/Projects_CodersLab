<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tweets</title>
</head>
<body>
    <ol>
        <c:forEach items="${tweets}" var="tweet">
            <li>${tweet} <a href="/tweet/details/${tweet.id}">show details</a></li>
        </c:forEach>
    </ol>
</body>
</html>
