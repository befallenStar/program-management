<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/class.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/copyright.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div class="box">
    <div class="profile" title="退出登录">
        <div class="icon"><i class="far fa-user"></i></div>
        <div class="user-name">${loginResult.username}</div>
    </div>
    <div class="class-pic">
        <img src="${pageContext.request.contextPath}/image/class.jpg" alt="这是课程图片"/>
    </div>
    <form class="class-profile" method="POST" action="${pageContext.request.contextPath}/course">
        <p>
            &emsp;&emsp;《软件项目管理》是软件工程专业开设的专业课程，以培训更加专业的软件项目管理者为目的，统计表明：97%项目的成功是由有经验的项目经理领导的结果。而且随着我国软件产业规模的不断扩大，保证项目的成功，需要
            更多高素质的项目管理者。该课程涉及内容广泛、实践性强、新技术新方法多。</p>
        <c:if test="${loginResult.course==null||loginResult.course.status==1}">
            <input
                    class="class-btn"
                    type="submit"
                    id="class-btn"
                    value="${loginResult.courseStatus}"
            />
        </c:if>
        <c:if test="${loginResult.course.status==0}">
            <input
                    class="class-btn"
                    type="submit"
                    id="class-btn"
                    value="${loginResult.courseStatus}"
                    disabled="disabled"
            />
        </c:if>
    </form>
    <iframe src="${pageContext.request.contextPath}/class/class_info" class="class-message">
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
<script src="${pageContext.request.contextPath}/js/class.js"></script>
</body>
</html>
