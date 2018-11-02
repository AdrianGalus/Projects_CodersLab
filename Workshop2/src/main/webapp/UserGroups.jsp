<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserGroups</title>
</head>
<body>
<%@ include file="../../../../Workshop2/src/main/webapp/header.jsp"%>
<br/>
<table border=1">
        <tr>
            <th>Number</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${userGroups}" var="userGroup" begin="0" varStatus="count">
            <tr>
                <th>${count.index+1}</th>
                <td>${userGroup.name}</td>
                <td><a href="/UserGroupDetails?id=${userGroup.id}">Show users</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
<%@ include file="footer.jsp"%>
</body>
</html>
