
<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/24
  Time: 14:25

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>学生首页</title>
    <link rel="stylesheet" href="../static/css/mdui.min.css">
</head>
<body class="mdui-drawer-body-left">

<!-- 导航栏 -->
<nav>

    <!-- TODO 间距 -->


    <div class="mdui-container-fluid">
        <div class="mdui-row">
            <div class="mdui-typo-headline mdui-center"><h4 class="mdui-text-center">${sessionScope.CurrentLesson}</h4></div>
        </div>
        <div class="mdui-row">
            <div class="mdui-typo mdui-col-xs-3 mdui-col-offset-xs-9">
                <h3>欢迎你 : ${sessionScope.name} <a href="${pageContext.request.contextPath}/logout">登出</a></h3>
            </div>
        </div>
        <div class="mdui-row">
            <div class="mdui-typo mdui-col-xs-3 mdui-col-offset-xs-9">
                <h5>
                    <label for="lessonDecision">切换课程</label>
                    <select id="lessonDecision" class="mdui-select" mdui-select="{position: 'bottom'}">

<%--                        先输出当前的课程 然后再输出其他课程--%>
                        <option value="${sessionScope.course.ID}">${sessionScope.course.name}</option>
                        <!-- TODO: 切换课程 -->
                        <c:forEach items="${sessionScope.LessonChoices}" var="lessonDemo">

                            <c:if test="${lessonDemo.key != sessionScope.course.ID}">
                                <option value="${lessonDemo.key}">${lessonDemo.value}</option>
                            </c:if>
                        </c:forEach>

                    </select>
                </h5>
            </div>
        </div>
        <div class="mdui-row">
            <div>
                <div class="mdui-bottom-nav mdui-bottom-nav-text-auto mdui-color-black">
                    <!-- TODO 跳转链接 -->
                    <a href="${pageContext.request.contextPath}/student/index" class="mdui-ripple mdui-ripple-white mdui-bottom-nav-active">
                        <i class="mdui-icon material-icons">home</i>
                        <label>首页</label>
                    </a>
                    <a href="${pageContext.request.contextPath}/student/lessoninfo" class="mdui-ripple mdui-ripple-white">
                        <i class="mdui-icon material-icons">info_outline</i>
                        <label>课程信息</label>
                    </a>
                    <a href="${pageContext.request.contextPath}/student/onlinehomework" class="mdui-ripple mdui-ripple-white">
                        <i class="mdui-icon material-icons">event_note</i>
                        <label>在线作业</label>
                    </a>
                    <a href="${pageContext.request.contextPath}/student/achievements" class="mdui-ripple mdui-ripple-white">
                        <i class="mdui-icon material-icons">library_books</i>
                        <label>成绩查询</label>
                    </a>
                </div>
            </div>
        </div>

    </div>
</nav>

<!-- 默认抽屉栏在左侧 -->
<div class="mdui-drawer">
</div>



<br><br><br>


<div class="mdui-card mdui-container">
    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">最新公告</div>
    </div>
    <div class="mdui-divider-inset mdui-m-y-3"></div>
    <div class="mdui-typo-headline mdui-row mdui-text-center mdui-m-b-2">${sessionScope.course.announcement}</div>
</div>



</body>
<script src="../static/js/jquery-3.4.1.min.js"></script>
<script src="../static/js/mdui.min.js"></script>
<!-- TODO: 切换课程 ajax -->
<script>
    $("#lessonDecision").change(function () {
        $.ajax({
            url : "${pageContext.request.contextPath}/student/index",
            type : "POST",
            data : {"data" : JSON.stringify($("#lessonDecision").val())}
        })
    })
</script>
</html>

