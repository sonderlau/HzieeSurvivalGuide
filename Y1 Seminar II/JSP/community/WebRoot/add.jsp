<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.*" 
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8" />
    <title>添加物业问题</title>
    <link rel="stylesheet" href="<%=basePath%>/static/css/add.css">
   	<script src="<%=basePath%>/static/js/jquery-1.9.0.min.js"></script>
   <!--  <script src="<%=basePath%>/static/js/register.js"></script>
    <script src="<%=basePath%>/static/js/jquery.add.js"></script>-->
	<script>
		$(document).ready(function(){
			$("#send").click(function(){
				var username = $("#username").val();
				var message = $("#add").val();
				if(username !== "" && message !== ""){
					alert("提交成功！");
				}else{
					alert("用户名或者物业问题填写不能为空！");
				}
			})
		})
	</script>
  </head>
  
  <body>
  	<div id="problem">
        <form action="add.do" method="post">
            <h2>用心服务在我家</h2>
            <div style="min-width:300px;">
                <div>
                    <input style="color: #000000" type="text" id="username" name="username" placeholder="请输入用户名" maxlength=15>
                </div>

                <div class="add">
                    <input type="text" id="add" name="username_message" placeholder="请输入您的物业问题">
                </div>
            </div>
            <div id="send">
                <button>提交</button>
            </div>
        </form>
    </div>
  </body>
</html>
