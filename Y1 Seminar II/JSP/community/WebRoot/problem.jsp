<%@ page language="java" import="java.util.*,cn.edu.hziee.model.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
   	<title>物业问题</title>
    <link rel="stylesheet" href="<%=basePath%>/static/css/problem.css">
   
   	<script src="<%=basePath%>/static/js/jquery-1.9.0.min.js"></script>
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
            <a href="add.jsp" id="login">添加问题</a>
        </div>
    </div>

    <div id="table">
        <h2 class="title">物业问题</h2>
        <table>
            <thead>
                <tr>
                    <th>业主用户名</th>
                    <th>物业问题</th>
                    <th>时间</th>
                    <th>物业解决方案</th>
                </tr>
            </thead>
            <%
	List<Vector<String[]>> list = (List<Vector<String[]>>)request.getAttribute("data");
	for(Vector<String[]> vec : list){
		if(vec.size()>0){
			String[] data = vec.get(0);//  "id","title","content","add_time"
	%>
            <tbody>
	           
	                <tr>
	                    <th><%=request.getParameter("username") %></th>
	                    <th><%=data[1] %></th>
	                  	<th></th>
	                    <th></th>
	                </tr>

            </tbody>
            	<%
		}
	}
	%>
        </table>
    </div>
</body>
</html>
