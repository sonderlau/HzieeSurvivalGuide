 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>关于我们</title>
    <link rel="stylesheet" href="<%=basePath%>/static/css/about.css">
  </head>
  
  <body>
    <div id="header">
        <div id="logo">
            <img src="<%=basePath%>/static/image/logo1.png"  width="110px" height="90px" alt="">
        </div>

        <div id="nav">
            <ul>
                <li><a href="index.jsp">首页</a></li>
                <li><a href="problem.jsp">物业问题</a></li>
                <li><a href="information.jsp">快递信息</a></li>
                <li><a href="about.jsp">关于我们</a></li>
            </ul>
        </div>

        <div id="bar">
            <a href="register.jsp" id="register">注册</a>
            <a href="login.jsp" id="login">登录</a>
        </div>
    </div>

    <div id="banner">
        <h4>ENJOY 工作与生活</h4>
        <div class="word">一群有趣的灵魂、聪明大脑、结实的肉体的人类</div>
    </div>

    <div id="qiyewenhua" class="w">
        <img src="<%=basePath%>/static/image/about_qiyewenhua.png" alt="">
        <h4>初心社区文化</h4>
        <p>愿景：致力于用心服务业主</p>
        <p>价值观：致良知、走正道、行王道</p>
        <p>使命：为物业赋能、让资产释放价值、让社区生活更美好</p>
    </div>

    <div id="bangonghuanjing" class="w">
        <h2 class="title">办公环境</h2>
        <ul>
            <li><img src="<%=basePath%>/static/image/about_bangonghuanjing1.png" alt=""></li>
            <li><img src="<%=basePath%>/static/image/about_bangonghuanjing2.png" alt=""></li>
            <li><img src="<%=basePath%>/static/image/about_bangonghuanjing3.png" alt=""></li>
            <li><img src="<%=basePath%>/static/image/about_bangonghuanjing4.png" alt=""></li>
            <li><img src="<%=basePath%>/static/image/about_bangonghuanjing5.png" alt=""></li>
            <li><img src="<%=basePath%>/static/image/about_bangonghuanjing6.png" alt=""></li>
        </ul>
    </div>
	
	<div id="footer">
        <div class="w">
            <dl>
                <dt>
                    <a href="about.jsp">关于我们</a>
                </dt>
                <dd>
                    <a href="about.jsp">关于我们</a>
                </dd>
                <dd>
                    <a href="about.jsp">关于我们</a>
                </dd>
                <dd>
                    <a href="about.jsp">关于我们</a>
                </dd>
            </dl>
            <dl>
                <dt>
                    <a href="problem.jsp">物业问题</a>
                </dt>
                <dd>
                    <a href="problem.jsp">物业问题</a>
                </dd>
                <dd>
                    <a href="problem.jsp">物业问题</a>
                </dd>
                <dd>
                    <a href="problem.jsp">物业问题</a>
                </dd>
            </dl>
            <dl>
                <dt>
                    <a href="information.jsp">快递信息</a>
                </dt>
                <dd>
                    <a href="information.jsp">快递信息</a>
                </dd>
                <dd>
                    <a href="information.jsp">快递信息</a>
                </dd>
                <dd>
                    <a href="information.html">快递信息</a>
            </dl>
            <div class="logo">
                <img src="<%=basePath%>/static/image/logo.png" alt="初心Logo" width="150px" height="150px">
            </div>
        </div>
    </div>
  </body>
</html>
