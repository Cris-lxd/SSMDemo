<%--
  Created by IntelliJ IDEA.
  User: 20224
  Date: 2020/10/20
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件</title>
    <script type="text/javascript" src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
<table>
    <tr>
        <th>序号</th>
        <th>名字</th>
        <th>点击下载</th>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.num}</td>
            <td>${list.name}</td>
            <td><a href="download2?id=${list.id}">下载</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
<script>

</script>
</html>
