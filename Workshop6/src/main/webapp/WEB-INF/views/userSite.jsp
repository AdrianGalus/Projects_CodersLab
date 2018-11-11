<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userSite</title>
</head>
<body>
    All your tweets!
    <jsp:include page="tweets.jsp"/>
    <a href="/home">Back</a>
</body>
</html>
