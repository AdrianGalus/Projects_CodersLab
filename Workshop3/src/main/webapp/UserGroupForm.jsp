<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserForm</title>
</head>
<body>
<%@ include file="header.jsp"%>
<br/>
<c:if test="${activity == 'delete'}">
    Are you sure to delete solution about ID ${id}?
    <form action="/userGroupManager" method="post">
        <input type="hidden" name="activity" value="delete">
        <input type="radio" name="id" value="${id}">yes
        <input type="radio" name="id" value="0" checked>no
        <input type="submit" value="Ok">
    </form>
</c:if>
<c:if test="${activity == 'add' || activity == 'edit'}">
    <form action="/userGroupManager" method="post">
        <c:if test="${activity == 'edit'}">
            <input type="hidden" name="activity" value="edit">
            <input type="number" min="1" name="id" placeholder="Id">
            <br/>
        </c:if>
        <c:if test="${activity == 'add'}">
            <input type="hidden" name="activity" value="add">
        </c:if>
        <input type="text" name="name" placeholder="Username">
        <br/>
        <input type="submit" value="Save">
    </form>
</c:if>
<br/>
<%@ include file="footer.jsp"%>
</body>
</html>
