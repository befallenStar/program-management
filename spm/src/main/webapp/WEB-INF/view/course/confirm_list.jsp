<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>确认选课</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<h1>确认选课</h1>
<table>
    <tr>
        <th><input type="checkbox" class="all"/></th>
        <th>编号</th>
        <th>学号</th>
    </tr>
    <c:forEach items="${courses}" var="course" varStatus="i">
        <tr>
            <td><input type="checkbox" class="chk" name="chk" value="${course.id}"/></td>
            <td>${i.count}</td>
            <td>${course.user.username}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">
            <a href="${pageContext.request.contextPath}" id="confirm">确认</a>
            /<a href="${pageContext.request.contextPath}" id="delete">删除</a>
        </td>
    </tr>
</table>
<script src="${pageContext.request.contextPath}/js/course/confirm_list.js"></script>
<script src="${pageContext.request.contextPath}/js/table.js"></script>
<script src="${pageContext.request.contextPath}/js/checkbox.js"></script>
</body>
</html>
