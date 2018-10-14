<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GroupDetails</title>
</head>
<body>
    <table border=1">
        <tr>
            <th>Number</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${users}" var="user" begin="0" varStatus="count">
            <tr>
                <th>${count.index+1}</th>
                <td>${user.userName}</td>
                <td><a href="/UserDetails?id=${user.id}">Show details</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
