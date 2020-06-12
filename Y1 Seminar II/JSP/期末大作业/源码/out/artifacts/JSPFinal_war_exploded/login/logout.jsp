<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/25
  Time: 12:10
  Made full of love by Sonder Lau
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Error !</title>
    <link href="${pageContext.request.contextPath}/static/css/error.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div id="particles-js">
    <canvas class="particles-js-canvas-el" style="width: 100%; height: 100%;"></canvas>
</div>

<div class="container">
    <div class="text">
        <h1>
            <!-- TODO: ERROR CODE -->
            成功登出
        </h1>

        <!-- TODO:  -->
        <h5>3s后将返回主页</h5>
    </div>
</div>
</body>

<script src="https://cdn.bootcdn.net/ajax/libs/particles.js/2.0.0/particles.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/ErrorParticles.js"></script>
</html>
