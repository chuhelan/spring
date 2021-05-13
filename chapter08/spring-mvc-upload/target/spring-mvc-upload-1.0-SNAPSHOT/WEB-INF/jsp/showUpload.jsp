<%--
  Created by IntelliJ IDEA.
  User: wmp231316
  Date: 13/5/2021
  Time: 下午1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
上传人：${name} <br>
上传文件：<br>
<c:forEach items="${fileList}" var="file">
    文件名为：${file} <br>
    <img src="upload/${file}" style="height: 200px;width:200px;border-radius: 25px; box-shadow: 0px 0px 12px #E0E0E0"/> <br>
</c:forEach>
</body>
</html>
