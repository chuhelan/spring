<%--
  Created by IntelliJ IDEA.
  User: wmp231316
  Date: 10/5/2021
  Time: 下午4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registerUser" method="post">
    用户名：<input type="text" name="username"/><br/>
    密&nbsp;&nbsp;&nbsp;码：<input type="text" name="password"/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
