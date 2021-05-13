<%--
  Created by IntelliJ IDEA.
  User: wmp231316
  Date: 13/5/2021
  Time: 下午1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/fileUpload" method="post" enctype="multipart/form-data">
    上传人：<input type="text" name="name"><br>
    请选择文件：<input type="file" name="uploadfile" multiple><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
