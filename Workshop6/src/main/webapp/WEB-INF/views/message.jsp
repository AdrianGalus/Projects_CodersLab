<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>message</title>
</head>
<body>
    ID: ${message.id}
    <br/>
    Sender: ${message.sender.userName}
    <br/>
    Theme: ${message.theme}
    <br/>
    Text: ${message.text}
    <br/>
    <a href="/home">Back</a>
</body>
</html>
