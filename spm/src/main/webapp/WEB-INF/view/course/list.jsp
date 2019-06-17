<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课名单</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<h1>选课名单</h1>
<table border="1">
    <tr>
        <th>编号</th>
        <th>学号</th>
        <th>状态</th>
    </tr>
    <c:forEach items="${courses}" var="course" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${course.user.username}</td>
            <td>已选中</td>
        </tr>
    </c:forEach>
</table>
<script src="${pageContext.request.contextPath}/js/table.js"></script>
</body>
</html>
