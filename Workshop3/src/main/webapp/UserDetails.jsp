<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserDetails</title>
</head>
<body>
<%@ include file="header.jsp"%>
    <br/>
    Name: ${user.userName}
    <br/>
    ID in DataBase: ${user.id}
    <br/>
    User Group ID: ${user.userGroupId}
    <br/>
    User's solutions:
    <br/>
    <table border="1">
        <tr>
            <th>Number</th>
            <th>Created</th>
            <th>Exercise ID</th>
            <th>User ID</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${solutions}" begin="0" var="solution" varStatus="count">
            <tr>
                <th>${count.index+1}</th>
                <td>${solution.created}</td>
                <td>${solution.exerciseId}</td>
                <td>${solution.usersId}</td>
                <td><a href="SolutionDetails?id=${solution.id}">Show details</a></td>
            </tr>
        </c:forEach>
    </table>
<br/>
<%@ include file="footer.jsp"%>
</body>
</html>
