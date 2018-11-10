<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form:form method="post" modelAttribute="user">
        <form:hidden path="userName" value="temporary"/>
        <form:errors path="userName"/>
        <form:input path="email" placeholder="email"/>
        <form:errors path="email"/>
        <form:password path="password" placeholder="password"/>
        <form:errors path="password"/>
        <input type="submit" value="Sign in"/>
    </form:form>
</body>
</html>
