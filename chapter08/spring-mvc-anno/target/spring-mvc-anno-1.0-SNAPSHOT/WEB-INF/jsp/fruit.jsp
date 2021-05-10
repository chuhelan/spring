<%--
  Created by IntelliJ IDEA.
  User: wmp231316
  Date: 6/5/2021
  Time: 下午2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示水果数据</title>
</head>
<body>
<table border="1px" width="600px">
    <thead>
    <th>名称</th>
    <th>价格</th>
    <th>产地</th>
    </thead>
    <tbody>
    <c:forEach items="${fruitList}" var="fruit">
        <tr>
            <td>${fruit.name}</td>
            <td>${fruit.price}</td>
            <td>${fruit.producing_area}</td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="3" align="center">@copy 软件1913</td>
    </tr>
    </tfoot>
</table>

</body>
</html>
