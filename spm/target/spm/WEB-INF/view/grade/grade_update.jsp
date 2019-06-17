<<<<<<< HEAD
=======
<%--
  Created by IntelliJ IDEA.
  User: Giovanni-Ch'ien
  Date: 2019/5/25
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩更新</title>
<<<<<<< HEAD
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/grade/grade_upgrade.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>

</head>
<body>
<h1>成绩修改</h1>
<form method="post" action="${pageContext.request.contextPath}/${jumpUrl}">
    <input type="hidden" value="${course.id}" name="id">
    <table border="1">
        <tr>
            <th colspan="2">成绩更新</th>
        </tr>
        <tr>
            <td>学号</td>
            <td>${course.user.username}</td>
        </tr>
        <tr>
            <td>平时成绩</td>
            <td><input type="text" value="${course.dailyGrade}" name="dailyGrade"></td>
        </tr>
        <tr>
            <td>期中成绩</td>
            <td><input type="text" value="${course.midGrade}" name="midGrade"></td>
        </tr>
        <tr>
            <td>期末成绩</td>
            <td><input type="text" value="${course.finalGrade}" name="finalGrade"></td>
        </tr>
        <tr>
            <td>实践成绩</td>
            <td><input type="text" value="${course.practiceGrade}" name="practiceGrade"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
<script src="${pageContext.request.contextPath}/js/table.js"></script>
=======
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/${jumpUrl}">
        <input type="hidden" value="${course.id}" name="id">
        <table border="1">
            <tr>
                <th colspan="2">成绩更新</th>
            </tr>
            <tr>
                <td>学号</td>
                <td>${course.user.username}</td>
            </tr>
            <tr>
                <td>平时成绩</td>
                <td><input type="text" value="${course.dailyGrade}" name="dailyGrade"></td>
            </tr>
            <tr>
                <td>期中成绩</td>
                <td><input type="text" value="${course.midGrade}" name="midGrade"></td>
            </tr>
            <tr>
                <td>期末成绩</td>
                <td><input type="text" value="${course.finalGrade}" name="finalGrade"></td>
            </tr>
            <tr>
                <td>实践成绩</td>
                <td><input type="text" value="${course.practiceGrade}" name="practiceGrade"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
</body>
</html>
