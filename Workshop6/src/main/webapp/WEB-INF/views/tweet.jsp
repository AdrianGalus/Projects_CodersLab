<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tweet</title>
</head>
<body>
    ID: ${tweet.id}
    <br/>
    User: ${tweet.user.userName}
    <br/>
    Created: ${tweet.created}
    <br/>
    Text: ${tweet.text}
    <br/>
    Comments: ----
    <br/>
    <a href="/home">Back</a>
</body>
</html>
