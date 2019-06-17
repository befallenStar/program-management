<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩导入</title>
<<<<<<< HEAD
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/import.css"/>
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
<h1>成绩导入</h1>
<form action="${pageContext.request.contextPath}/grade/import" method="post"
      enctype="multipart/form-data" id="import">
    <input id="file" type="file" name="file" accept=".xls,.xlsx">
    <input type="submit" value="导入" id="submit">
=======
</head>
<body>
<script type="text/javascript">
    function checkData() {
        var fileDir = $("file").val();
        var suffix = fileDir.substr(fileDir.lastIndexOf("."));
        if(""===fileDir){
            alert("选择需要导入的Excel文件");
            return false;
        }
        if(".xls"!==suffix&&".xlsx"!==suffix){
            alert("选择Excel格式的文件导入");
            return false;
        }
        return true;
    }
</script>
<form action="${pageContext.request.contextPath}/grade/import" method="post" enctype="multipart/form-data">
    <input id="file" type="file" name="file" accept=".xls,.xlsx">
    <input type="submit" value="导入" onclick="return checkData()">
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
</form>
<table>
    <tr>
        <th>编号</th>
        <th>学号</th>
        <th>平时成绩</th>
        <th>期中成绩</th>
        <th>期末成绩</th>
        <th>实践成绩</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${courses}" var="course" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${course.user.username}</td>
            <td>${course.dailyGrade}</td>
            <td>${course.midGrade}</td>
            <td>${course.finalGrade}</td>
            <td>${course.practiceGrade}</td>
<<<<<<< HEAD
            <td>
                <a href="${pageContext.request.contextPath}/grade/update_import?id=${course.id}">修改</a>
            </td>
=======
            <td><a href="${pageContext.request.contextPath}/grade/update_import?id=${course.id}">修改</a></td>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7">
<<<<<<< HEAD
            <a href="" id="confirm"> 确认 </a>
        </td>
    </tr>
</table>
<script src="${pageContext.request.contextPath}/js/table.js"></script>
<script src="${pageContext.request.contextPath}/js/grade/grade_import.js"></script>
=======
            <a href="${pageContext.request.contextPath}/grade/submit_import">
                <input type="button" value="确认">
            </a>
        </td>
    </tr>
</table>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
</body>
</html>
