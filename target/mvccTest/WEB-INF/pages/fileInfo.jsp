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

    <a href="prePage?page=${map.prePage}" id="prePage" >上一页</a>
    <a href="nextPage?page=${map.nextPage}" id="nextPage">下一页</a>
    <p>总页数：${pagenum}</p>
    <p>当前页：${map.currentPage}</p>
    <input type="hidden" id="currentPage" value="${map.currentPage}"/>
    <input type="hidden" id="pagenum" value="${pagenum}"/>
</body>
<script>
    $(function check(){
        var prePage = document.getElementById('prePage');
        var nextPage = document.getElementById('nextPage');
        debugger;
        if($('#currentPage').val()==1){
            //alert('yes');
            prePage.style.display = 'none';
        }
        if($('#currentPage').val()==$('#pagenum').val()){
            nextPage.style.display = 'none';
        }
        console.log($('#currentPage').val());
        console.log($('#pagenum').val());
    })
</script>
</html>
