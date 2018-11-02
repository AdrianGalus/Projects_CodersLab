<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ExerciseForm</title>
</head>
<body>
<%@ include file="../../../../Workshop3/src/main/webapp/header.jsp"%>
<br/>
<c:if test="${activity == 'delete'}">
    Are you sure to delete solution about ID ${id}?
    <form action="/exerciseManager" method="post">
        <input type="hidden" name="activity" value="delete">
        <input type="radio" name="id" value="${id}">yes
        <input type="radio" name="id" value="0" checked>no
        <input type="submit" value="Ok">
    </form>
</c:if>
<c:if test="${activity == 'add' || activity == 'edit'}">
    <form action="/exerciseManager" method="post">
        <c:if test="${activity == 'edit'}">
            <input type="hidden" name="activity" value="edit">
            <input type="number" min="1" name="id" placeholder="Id">
            <br/>
        </c:if>
        <c:if test="${activity == 'add'}">
            <input type="hidden" name="activity" value="add">
        </c:if>
        <input type="text" name="title" placeholder="Title">
        <br/>
        <input type="text" name="description" placeholder="Description">
        <br/>
        <input type="submit" value="Save">
    </form>
</c:if>
<br/>
<%@ include file="../../../../Workshop3/src/main/webapp/footer.jsp"%>
</body>
</html>
