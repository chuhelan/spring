<%--
  Created by IntelliJ IDEA.
  User: wmp231316
  Date: 18/5/2021
  Time: 上午8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="400px">
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>职业</td>
        <td>电话</td>
    </tr>
    <tr>
        <td>${customer.id}</td>
        <td>${customer.username}</td>
        <td>${customer.jobs}</td>
        <td>${customer.phone}</td>
    </tr>
</table>

</body>
</html>
