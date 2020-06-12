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
    <title>登陆</title>
    <!-- 登陆界面的CSS -->
    <link href="../static/css/login.css">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
    <form action="${pageContext.request.contextPath}/Login/confirm">
        <input name="code" type="text">
        <input name="password" type="password">
        <select name="identity">
            <option value="s">学生</option>
            <option value="t">老师</option>
        </select>
        <input type="submit">
    </form>

</body>
</html>
