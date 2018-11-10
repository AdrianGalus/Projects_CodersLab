<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form:form method="post" modelAttribute="user">
        <form:input path="userName" placeholder="userName"/>
        <form:errors path="userName"/>
        <form:password path="password" placeholder="password"/>
        <form:errors path="password"/>
        <form:input path="email" placeholder="email"/>
        <form:errors path="email"/>
        <input type="submit" value="Join!"/>
    </form:form>
</body>
</html>
