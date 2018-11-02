<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SolutionDetails</title>
</head>
<body>
<%@ include file="header.jsp"%>
    <br/>
    Created: ${solution.created}
    <br/>
    Updated: ${solution.updated}
    <br/>
    ID in DataBase: ${solution.id}
    <br/>
    Exercise ID: ${solution.exerciseId}
    <br/>
    User ID: ${solution.usersId}
    <br/>
    Description: ${solution.description}
    <br/>
    <a href="/Main">Wróć</a>
    <br/>
<%@ include file="footer.jsp"%>
</body>
</html>
