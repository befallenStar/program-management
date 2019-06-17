<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="text/html;charset=UTF-8"/>
    <title>网上测试</title>
    <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/student/test.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<c:if test="${loginResult.course.dailyGrade!=null}">
<<<<<<< HEAD
    <p>网上测试结果为:${loginResult.course.dailyGrade}</p>
=======
    网上测试结果为:${loginResult.course.dailyGrade}
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
</c:if>
<c:if test="${loginResult.course.dailyGrade==null}">
    <form method="post" action="${pageContext.request.contextPath}/student/completePaper">
        <c:forEach items="${paper}" var="question" varStatus="i">
            <%--单选题--%>
            <c:if test="${question.type==1}">
<<<<<<< HEAD
                ${i.count}.&emsp;${question.question}<br>
=======
                ${i.count}.&nbsp;${question.question}<br>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
                <c:forEach items="${question.options}" var="option">
                    <input type="radio" name="question${i.count}" value="${option.key}">${option.value}<br>
                </c:forEach>
            </c:if>
            <%--多选题--%>
            <c:if test="${question.type==2}">
<<<<<<< HEAD
                ${i.count}.&emsp;${question.question}<br>
=======
                ${i.count}.&nbsp;${question.question}<br>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
                <c:forEach items="${question.options}" var="option">
                    <input type="checkbox" name="question${i.count}" value="${option.key}">${option.value}<br>
                </c:forEach>
            </c:if>
            <%--判断题--%>
            <c:if test="${question.type==3}">
<<<<<<< HEAD
                ${i.count}.&emsp;${question.question}<br>
=======
                ${i.count}.&nbsp;${question.question}<br>
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
                <c:forEach items="${question.options}" var="option">
                    <input type="radio" name="question${i.count}" value="${option.key}">${option.value}<br>
                </c:forEach>
            </c:if>
        </c:forEach>
        <input type="submit" value="提交"/>
    </form>
</c:if>
<script src="${pageContext.request.contextPath}/js/student/test.js">

</script>
</body>
</html>
