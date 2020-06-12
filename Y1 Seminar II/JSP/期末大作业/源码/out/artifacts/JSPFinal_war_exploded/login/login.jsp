<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/24
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆</title>
    <!-- 登陆界面的CSS -->

    <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/5.13.0/css/fontawesome.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="../static/css/login.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/mdui.min.css" rel="stylesheet">
    <style>
        .flexCenter {
            display: flex;
            justify-content: center;
            margin-top: 36px;
        }
    </style>
</head>
<body>
<div class="main">
    <p class="sign" style="text-align: center">登陆</p>

    <form action="${pageContext.request.contextPath}/Login/confirm" class="mainForm">
        <input name="code" type="text" class="un" placeholder="学号">
        <input name="password" type="password" class="pass" placeholder="密码">
        <div class="mdui-container-fluid mdui-row-xs-2 mdui-m-x-4">
            <div class="mdui-col">
                <label class="mdui-radio">
                    <input type="radio" name="identity" value="s" checked> <i class="mdui-radio-icon"></i> 学生
                </label>
            </div>
            <div class="mdui-col mdui-p-l-5">
                <label class=" mdui-radio">
                    <input type="radio" name="identity" value="t"> <i class="mdui-radio-icon"></i> 老师
                </label>
            </div>
        </div>

        <div class="flexCenter">
            <input type="submit" class="mdui-btn mdui-btn-raised mdui-color-blue mdui-text-color-white-text" id="submit" value="登陆">
        </div>

    </form>
</div>

</body>

<script src="${pageContext.request.contextPath}/static/js/mdui.min.js"></script>
</html>
