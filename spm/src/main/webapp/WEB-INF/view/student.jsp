<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="text/html;charset=utf-8"/>
    <title>学生</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/copyright.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div class="box">
    <div class="top">
        <div class="pic">
            <img src="${pageContext.request.contextPath}/image/nnu-logo.png" alt="学校图标"/>
        </div>
        <div class="class-name"><p>软件项目课程管理&emsp;授课教师：杨俊</p></div>
        <div class="profile" title="退出登录">
            <div class="icon"><i class="far fa-user"></i></div>
            <div class="user-name">${loginResult.username}</div>
        </div>
    </div>
    <div class="menu">
        <ul>
            <li id="info"><span>课程信息</span>
                <ul class="hide">
                    <li id="content">课程内容</li>
                    <li id="practice">课程实践</li>
                    <li id="team">教学团队</li>
                </ul>
            </li>
            <li id="test"><span>网上测试</span></li>
            <li id="grade"><span>成绩查询</span></li>
            <li id="resource"><span>资源区</span></li>
            <li id="message"><span>留言板</span></li>
            <li id="work"><span>行业信息</span></li>
            <li id="contact"><span>联系我们</span></li>
        </ul>
    </div>
    <iframe src="${pageContext.request.contextPath}/class/class_info" class="main">
    </iframe>
    <div class="copyRight">
        <p>
            @CopyRight
        </p>
        <p>
            南京师范大学
        </p>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/logout.js"></script>
<script src="${pageContext.request.contextPath}/js/student.js"></script>
</body>
</html>
