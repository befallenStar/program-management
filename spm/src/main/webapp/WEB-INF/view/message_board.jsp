<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/message_board.css"/>
</head>
<body>
<h1>留言板</h1>
<hr>
<c:forEach items="${msgList}" var="msg">
    <p>${msg.content}</p>
    <p>${msg.user.username}&emsp;&emsp;${msg.time}</p>
    <hr>
</c:forEach>
<a href="${pageContext.request.contextPath}/message/message_board?page=1">|<</a>&emsp;
<c:forEach var="i" begin="1" end="${page.pages}">
    <a href="${pageContext.request.contextPath}/message/message_board?page=${i}">${i}</a>&emsp;
</c:forEach>
<a href="${pageContext.request.contextPath}/message/message_board?page=${page.pages}">>|</a>
<hr>
<form method="post" action="${pageContext.request.contextPath}/message/leave">
    <textarea name="content" rows="5" cols="25"></textarea><br>
    <input type="submit" value="留言">
</form>
</body>
</html>
