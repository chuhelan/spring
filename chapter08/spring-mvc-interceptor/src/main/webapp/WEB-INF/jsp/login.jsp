<%--
  Created by IntelliJ IDEA.
  User: wmp231316
  Date: 11/5/2021
  Time: 上午9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
${msg}
<form action="/userController/login" method="post">
    用户名：<input type="text" name="username"> <br>
    密&nbsp;&nbsp;码：<input type="password" name="password"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
