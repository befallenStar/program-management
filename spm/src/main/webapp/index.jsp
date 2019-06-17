<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>软件项目管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
    <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    />
    <script  src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<script >
    $(document).ready(function () {
        var msg = "${msg}";
        if (msg !== "") {
            alert(msg);
        }
    });
</script>
<a href="${pageContext.request.contextPath}/signIn.jsp">
<div class="show-signin-btn">
    <h1>软件项目管理课程</h1>
    <i class="fas fa-sign-in-alt"></i>
    点击进入
</div>
</a>
</body>
</html>
