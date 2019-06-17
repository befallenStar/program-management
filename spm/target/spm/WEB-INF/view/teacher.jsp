<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师</title>
<<<<<<< HEAD
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
            <li id="course"><span>选课管理</span>
                <ul class="hide">
                    <li id="chooseList">选课名单</li>
                    <li id="confirm">确认选课</li>
                </ul>
            </li>
            <li id="score"><span>成绩管理</span>
                <ul class="hide">
                    <li id="import">成绩导入</li>
                    <li id="analyse">成绩分析</li>
                    <li id="report">成绩通知</li>
                </ul>
            </li>
            <li id="resource"><span>资源管理</span></li>
            <li id="message"><span>留言板</span></li>
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
<script src="${pageContext.request.contextPath}/js/teacher.js"></script>
=======
    <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    />
    <link
            rel="stylesheet"
            href="${pageContext.request.contextPath}/css/teacher.css"
    />
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div class="teacher-box">
    <div class="teacher-class">
        <div class="pic">
            <img src="${pageContext.request.contextPath}/image/class_small.jpg" alt="小课程图片"/>
            <div class="name">软件项目课程管理</div>
        </div>
    </div>
    <div class="teacher-profile">
        <div class="teacher-message"><i class="far fa-envelope"></i></div>
        <div class="teacher-icon"><i class="far fa-user"></i></div>
        <div class="teacher-name">${loginResult.username}</div>
    </div>
    <div class="teacher-menu">
        <ul>
            <li class="first"><a href="#" id="course">选课管理</a>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/course/list" id="confirm">选课名单</a></li>
                    <li><a href="${pageContext.request.contextPath}/course/confirmList" id="setting">确认选课</a></li>
                </ul>
            </li>
            <li><a href="${pageContext.request.contextPath}/resource/show" id="resource">资源管理</a></li>
            <li class="last"><a href="${pageContext.request.contextPath}/grade/show" id="score">成绩管理</a>
                <ul class="sublast">
                    <li><a href="${pageContext.request.contextPath}/grade/show_import" id="import">成绩导入</a></li>
                    <li><a href="#" id="analyse">成绩分析</a></li>
                    <li><a href="${pageContext.request.contextPath}/grade/notice_list" id="report">成绩通知</a></li>
                </ul>
            </li>
            <li><a href="${pageContext.request.contextPath}/message/message_board?page=1" id="message_board">留言板</a></li>
        </ul>
    </div>
    <iframe src="${pageContext.request.contextPath}/class/class_info" id="teacher-main">
    </iframe>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/teacher.js"></script>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
</body>
</html>
