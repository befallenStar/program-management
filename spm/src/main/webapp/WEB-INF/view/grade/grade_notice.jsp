<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>成绩预警</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/grade/grade_notice.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<script>
    $(document).ready(function () {
        var msg = "${msg}";
        if (msg !== "") {
            alert(msg);
        }
    });
</script>
<h1>成绩通知</h1>
<form action="${pageContext.request.contextPath}/grade/notice" method="post">
<table>
    <tr>
        <th><input type="checkbox" class="all"/></th>
        <th>编号</th>
        <th>学号</th>
        <th>平时成绩</th>
        <th>期中成绩</th>
        <th>期末成绩</th>
        <th>实践成绩</th>
        <th>总成绩</th>
    </tr>
    <c:forEach items="${courses}" var="course" varStatus="i">
        <tr>
            <td><input type="checkbox" class="chk" name="chk" value="${course.id}"></td>
            <td>${i.count}</td>
            <td>${course.user.username}</td>
            <td>${course.dailyGrade}</td>
            <td>${course.midGrade}</td>
            <td>${course.finalGrade}</td>
            <td>${course.practiceGrade}</td>
            <td>${course.totalGrade}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="8"><input type="submit" value="通知"></td>
    </tr>
</table>
</form>
<script src="${pageContext.request.contextPath}/js/table.js"></script>
<script src="${pageContext.request.contextPath}/js/checkbox.js"></script>
</body>
</html>
