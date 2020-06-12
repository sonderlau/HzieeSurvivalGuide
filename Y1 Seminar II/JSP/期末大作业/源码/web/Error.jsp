<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/24
  Time: 20:03
  To change this template use File | Settings | File Templates.
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

            ${sessionScope.errorCode}
        </h1>


        <h5>${sessionScope.errorMsg}</h5>

        <!-- TODO:返回主页的参数 -->
        <p> <a href="${pageContext.request.contextPath}/${sessionScope.errorAddress}">返回主页</a></p>
      </div>
    </div>
</body>

<script src="https://cdn.bootcdn.net/ajax/libs/particles.js/2.0.0/particles.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/ErrorParticles.js"></script>
</html>
