<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel admin</title>
</head>
<body>
<%@ include file="header.jsp"%>
    <br/>
    <h1>Panel admin</h1>
    <a href="/panelAdmin?choice=solution">Solution Manager</a>
    <br/>
    <a href="/panelAdmin?choice=user">User Manager</a>
    <br/>
    <a href="/panelAdmin?choice=userGroup">User Group manager</a>
    <br/><br/>
<c:if test="${not empty solutions}">
    <h2>Solutions</h2>
    <br/>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Created</th>
            <th>Exercise ID</th>
            <th>User ID</th>
            <th>Action</th>
        </tr>
    <c:forEach items="${solutions}" var="solution">
        <tr>
            <td>${solution.id}</td>
            <td>${solution.created}</td>
            <td>${solution.exerciseId}</td>
            <td>${solution.usersId}</td>
            <td><a href="/solutionManager?activity=edit">Edit</a>
                <a href="/solutionManager?activity=delete&id=${solution.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
    <a href="/solutionManager?activity=add">Add new</a>
    <br/>
</c:if>
<c:if test="${not empty users}">
    <h2>Users</h2>
    <br/>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>User Group ID</th>
            <th>Action</th>
        </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td>${user.userGroupId}</td>
            <td><a href="/userManager?activity=edit">Edit</a>
                <a href="/userManager?activity=delete&id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
    <a href="/userManager?activity=add">Add new</a>
    <br/>
</c:if>
<c:if test="${not empty userGroups}">
    <h2>User Groups</h2>
    <br/>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
    <c:forEach items="${userGroups}" var="userGroup">
        <tr>
            <td>${userGroup.id}</td>
            <td>${userGroup.name}</td>
            <td><a href="/userGroupManager?activity=edit">Edit</a> <a href="/userGroupManager?activity=delete">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
    <a href="/userGroupManager?activity=add">Add new</a>
    <br/>
</c:if>
<br/>
<%@ include file="footer.jsp"%>
</body>
</html>
