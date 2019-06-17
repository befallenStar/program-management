<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="text/html;charset=UTF-8"/>
    <title>在线资源</title>
<<<<<<< HEAD
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/import.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<h1>资源管理</h1>
<c:if test="${loginResult.power == 0}">
    <form action="${pageContext.request.contextPath}/resource/upload" method="post"
          enctype="multipart/form-data" id="upload">
        <input type="file" id="file" name="file">
        <input type="submit" value="上传" id="submit">
    </form>
</c:if>
=======
    <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/resource.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<c:if test="${loginResult.power == 0}">
    <form action="${pageContext.request.contextPath}/resource/upload" method="post"
          enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="上传">
    </form>
</c:if>
<form>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
    <table id="resource">
        <tr class="tr_head">
            <th>名称</th>
            <th>更新时间</th>
            <th>操作</th>
        </tr>
        <c:forEach var="file" items="${files}">
            <tr>
                <td>${file.realname}</td>
                <td>${file.time}</td>
                <td>
<<<<<<< HEAD
                    <a href="${pageContext.request.contextPath}/resource/download?id=${file.id}">下载</a>
                    <c:if test="${loginResult.power == 0}">
                        /<a href="${pageContext.request.contextPath}/resource/delete?id=${file.id}">删除</a>
=======
                    <a href="${pageContext.request.contextPath}/resource/download?id=${file.id}"><input type="button" value="下载"></a>
                    <c:if test="${loginResult.power == 0}">
                        <a href="${pageContext.request.contextPath}/resource/delete?id=${file.id}"><input type="button" value="删除"/></a>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
<<<<<<< HEAD
<script src="${pageContext.request.contextPath}/js/table.js"></script>
=======
</form>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
<script src="${pageContext.request.contextPath}/js/resource.js"></script>
</body>
</html>
