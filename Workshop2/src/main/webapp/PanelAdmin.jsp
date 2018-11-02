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
    <br/>
    <a href="/panelAdmin?choice=exercises">Exercises</a>
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
            <td><a href="/userGroupManager?activity=edit">Edit</a>
                <a href="/userGroupManager?activity=delete&id=${userGroup.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
    <a href="/userGroupManager?activity=add">Add new</a>
    <br/>
</c:if>
<c:if test="${not empty exercises}">
    <h2>Exercises</h2>
    <br/>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${exercises}" var="exercise">
            <tr>
                <td>${exercise.id}</td>
                <td>${exercise.title}</td>
                <td>${exercise.description}</td>
                <td><a href="/exerciseManager?activity=edit">Edit</a>
                    <a href="/exerciseManager?activity=delete&id=${exercise.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/exerciseManager?activity=add">Add new</a>
    <br/>
</c:if>
<br/>
<%@ include file="../../../../Workshop3/src/main/webapp/footer.jsp"%>
</body>
</html>
