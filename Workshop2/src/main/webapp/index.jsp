<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<%@ include file="header.jsp"%>
<br/>
    <table border=1">
        <tr>
            <th>Number</th>
            <th>Created</th>
            <th>Exercise Id</th>
            <th>Users Id</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${solutions}" var="solution" begin="0" varStatus="count">
        <tr>
            <th>${count.index+1}</th>
            <td>${solution.created}</td>
            <td>${solution.exerciseId}</td>
            <td>${solution.usersId}</td>
            <td><a href="/SolutionDetails?id=${solution.id}">Show details</a></td>
        </tr>
        </c:forEach>
    </table>
    <br/>
<%@ include file="../../../../Workshop3/src/main/webapp/footer.jsp"%>
</body>
</html>
