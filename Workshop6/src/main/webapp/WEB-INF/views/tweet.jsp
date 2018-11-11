<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tweet</title>
</head>
<body>
    ID: ${tweet.id}
    <br/>
    User: ${tweet.user.userName}
    <br/>
    Created: ${tweet.created}
    <br/>
    Text: ${tweet.text}
    <br/>
    Comments: <jsp:include page="comments.jsp"/>
    <br/>
    <c:if test="${not empty user}">
        <form:form action="/comment/create/${tweet.id}" method="post" modelAttribute="comment">
            <form:textarea path="text" placeholder="text"/>
            <form:errors path="text"/>
            <input type="submit" value="Add"/>
        </form:form>
    </c:if>
    <a href="/home">Back</a>
</body>
</html>
