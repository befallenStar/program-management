<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>选课</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/student/selectCourse.css" />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    />
    <script
<<<<<<< HEAD

=======
      type="text/javascript"
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
      src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"
    ></script>
  </head>
  <body>
    <div class="select-box">
      <form
        class="select-form"
        method="POST"
        action="${pageContext.request.contextPath}/selectCourse"
      >
        <h1>请输入个人信息</h1>
        <input
          class="txtb"
          type="text"
          id="select-mail"
          name="email"
          placeholder="Your e-mail"
        />
        <input
          class="txtb"
          type="text"
          id="select-phone"
          name="phone"
          placeholder="Your phone number"
        />
        <input
          class="select-btn"
          type="submit"
          id="select-btn"
          value="进入学习"
        />
      </form>
    </div>
  </body>
</html>
