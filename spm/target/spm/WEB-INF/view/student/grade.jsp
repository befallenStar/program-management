<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩查询</title>
<<<<<<< HEAD
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<h1>成绩查询</h1>
<table>
    <tr>
=======
</head>
<body>
<table>
    <tr>
        <th colspan="2">成绩查询</th>
    </tr>
    <tr>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
        <td>学号</td>
        <td>${loginResult.username}</td>
    </tr>
    <tr>
        <td>平时成绩</td>
        <td>${loginResult.course.dailyGrade}</td>
    </tr>
    <tr>
        <td>期中成绩</td>
        <td>${loginResult.course.midGrade}</td>
    </tr>
    <tr>
        <td>期末成绩</td>
        <td>${loginResult.course.finalGrade}</td>
    </tr>
    <tr>
        <td>实践成绩</td>
        <td>${loginResult.course.practiceGrade}</td>
    </tr>
    <tr>
        <td>总成绩</td>
        <td>${loginResult.course.totalGrade}</td>
    </tr>
</table>
<<<<<<< HEAD
<script src="${pageContext.request.contextPath}/js/table.js"></script>
=======
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
</body>
</html>
