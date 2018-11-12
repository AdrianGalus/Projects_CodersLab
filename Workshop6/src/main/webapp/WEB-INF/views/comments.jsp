<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>comments</title>
</head>
<body>
    <ol>
        <c:forEach items="${comments}" var="loadComment">
            <li>${loadComment}</li>
        </c:forEach>
    </ol>
</body>
</html>
