<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signUp.css"/>
    <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    />
<<<<<<< HEAD
    <script  src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<script >
=======
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<script type="text/javascript">
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
    $(document).ready(function () {
        var msg = "${msg}";
        if (msg !== "") {
            alert(msg);
        }
    });
</script>
<div class="signup-box">
    <a href="${pageContext.request.contextPath}/index.jsp">
    <div class="hide-signup-btn">
        <i class="fas fa-times"></i>
    </div>
    </a>
    <form class="signup-form" method="POST" action="${pageContext.request.contextPath}/signUp">
        <h1>欢迎进入</h1>
        <input
                class="txtb"
                type="text"
                id="signup-usr"
                placeholder="Username"
                name="username"
        />
        <input
                class="txtb"
                type="password"
                id="signup-pwd"
                placeholder="Password"
                name="password"
        />
        <input
                class="txtb"
                type="password"
                id="signup-cpwd"
                placeholder="Confirm Password"
                name="reInputPwd"
        />
        <input class="signup-btn" type="submit" value="注册"/>
    </form>
</div>
</body>
</html>
