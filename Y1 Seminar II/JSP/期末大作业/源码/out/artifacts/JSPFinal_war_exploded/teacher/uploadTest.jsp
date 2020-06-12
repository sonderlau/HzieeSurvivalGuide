<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/27
  Time: 16:35
  Made full of love by Sonder Lau
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传测试</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/teacher/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="myFile" >
        <input type="submit" value="上传" >
    </form>


</body>
</html>
