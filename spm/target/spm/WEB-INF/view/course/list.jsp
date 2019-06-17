<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<<<<<< HEAD
=======
<%--
  Created by IntelliJ IDEA.
  User: Giovanni-Ch'ien
  Date: 2019/5/24
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课名单</title>
<<<<<<< HEAD
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<h1>选课名单</h1>
<table border="1">
    <tr>
=======
</head>
<body>
<table border="1">
    <tr>
        <th colspan="3">选课名单</th>
    </tr>
    <tr>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
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
<<<<<<< HEAD
<script src="${pageContext.request.contextPath}/js/table.js"></script>
=======
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
</body>
</html>
