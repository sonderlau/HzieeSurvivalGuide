<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
	<link rel="stylesheet" href="<%=basePath%>/static/css/login.css">
    <script src="<%=basePath%>/static/js/jquery-1.9.0.min.js"></script>
  </head>
  
  <body>
    <div id="login">
        <div class="logo"><img src="<%=basePath%>/static/image/logo1.png" alt=""></div>
        <div>
            <form method="post" action="login.do">
                <div class="input">
                    <div class="username">
                        <input type="text" placeholder="请输入用户名" id="username" name="username">
                    </div>
                    <div class="password">
                        <input type="password" placeholder="请输入密码" id="password" name="password">
                    </div>
                </div>
                <div class="submit">
                    <button type="submit" id="submit">
                        <span>登录</span>
                    </button>
                </div>
                <div class="register">
                    <span>还没有账号？</span>
                    <a href="register.jsp" id="register">立即注册</a>
                </div>
            </form>
        </div>
    </div>
  </body>
</html>
