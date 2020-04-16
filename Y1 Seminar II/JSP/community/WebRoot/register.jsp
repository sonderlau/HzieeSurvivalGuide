<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    <link rel="stylesheet" href="<%=basePath%>/static/css/register.css">
    <script src="<%=basePath%>/static/js/jquery-1.9.0.min.js"></script>
    <script src="<%=basePath%>/static/js/register.js"></script>
    <script src="<%=basePath%>/static/js/jquery.register.js"></script>
  </head>
  
  <body>
    <div id="register">
        <form action="register.do" method="post">
            <h2>用心服务在我家</h2>
            <div style="min-width:300px;">
                <div>
                    <input style="color: #000000" type="text" id="username" name="username" placeholder="请输入用户名" maxlength=15 onclick="JavaScript:this.value=''" pattern="\w{3,12}">
                </div>

                <div class="password">
                    <input type="password" id="password" name="password" placeholder="请输入密码" onclick="JavaScript:this.value=''" pattern="\w{3,12}">
                </div>

                <div class="checkPassword">
                    <input type="password" id="checkPassword" name="checkPassword" placeholder="请再次输入密码">
                </div>
            </div>
            <div id="send">
                <button>注册</button>
            </div>
            <div style="margin-top:10px" class="login">
                <span>已有账号？</span>
                <a href="login.jsp" id="login">立即登录</a>
            </div>
        </form>
    </div>
  </body>
</html>
