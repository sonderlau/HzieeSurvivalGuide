<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/28
  Time: 23:39
  Made full of love by Sonder Lau
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>作业管理</title>
</head>
<body>

${sessionScope.homeworkArrayList}
<c:forEach items="${sessionScope.homeworkArrayList}" var="homeworks">
     ID ${homeworks.ID} <br>
    分配的班级 ${homeworks.arrange_For} <br>
    起止时间 从 ${homeworks.start_Time.toString()} 到 ${homeworks.end_Time.toString()}
    操作 编辑 复制 删除 <br>
    评阅
    <c:choose>
        <c:when test="${homeworks.need_For_Review == 1}">
            需要评阅的按钮
        </c:when>
        <c:otherwise>
            不需要评阅的按钮
        </c:otherwise>
    </c:choose>

</c:forEach>

<br> <br> <br>
布置作业 <br>



</body>
</html>
