<%--
  Created by IntelliJ IDEA.
  User: 20224
  Date: 2020/10/28
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/canvas.css"/>
</head>
<body>
<canvas width="800" height="400" id="canvas"><p class="nope">No canvas, no particles</p></canvas>
<header>
    <h1>Particle Clock</h1>
    <div id="about">
        <a href="#" id="toggle-options"></a>
        <ul id="options">
            <li><a href="#" id="quivers" class="">Quiver</a></li>
            <li><a href="#" id="gradient" class="on">Gradient</a></li>
            <li><a href="#" id="color" class="on">Colorize</a></li>
            <li><a href="#" id="valentineify" class="">Valentine-ify</a></li>
            <li class="group"><span>Mouse down: explode and repel</span></li>
            <li><span>Mouse down + shift: explode and attract</span></li>
            <li><span>Arrow Up: increase particle size</span></li>
            <li class="group"><span>Sorry about your CPU</span></li>
            <li><span id="fps"></span></li>
        </ul>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/canvas.js"/>
</header>
</body>
</html>
