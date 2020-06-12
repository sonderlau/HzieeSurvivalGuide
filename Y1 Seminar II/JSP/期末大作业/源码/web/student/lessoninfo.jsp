<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/25
  Time: 12:09
  Made full of love by Sonder Lau
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>学生 : 课程信息</title>
    <link rel="stylesheet" href="../static/css/mdui.min.css"/>
    <!-- 富文本编辑器的渲染 -->
    <link rel="stylesheet" href="../static/css/wangEditor.css">
</head>
<body class="mdui-drawer-body-left">
<!-- 导航栏 -->
<nav>
    <!-- TODO 间距 -->

    <div class="mdui-container-fluid">
        <div class="mdui-row">
            <div class="mdui-typo-headline mdui-center">
                <h4 class="mdui-text-center">${sessionScope.CurrentLesson}</h4>
            </div>
        </div>
        <div class="mdui-row">
            <div class="mdui-typo mdui-col-xs-3 mdui-col-offset-xs-9">
                <h3>
                    欢迎你 : ${sessionScope.name}
                    <a href="${pageContext.request.contextPath}/logout">登出</a>
                </h3>
            </div>
        </div>
        <div class="mdui-row">
            <div class="mdui-typo mdui-col-xs-3 mdui-col-offset-xs-9">
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
                    <a href="${pageContext.request.contextPath}/student/index" class="mdui-ripple mdui-ripple-white">
                        <i class="mdui-icon material-icons">home</i>
                        <label>首页</label>
                    </a>
                    <a href="${pageContext.request.contextPath}/student/lessoninfo" class="mdui-ripple mdui-ripple-white mdui-bottom-nav-active">
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

    <div class="mdui-collapse-item mdui-collapse-item-open">

        <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
            <i class=" mdui-list-item-icon mdui-icon material-icons">info_outline</i>
            <div class="mdui-list-item-content">课程信息</div>
            <i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
        </div>

        <div class="mdui-collapse-item-body mdui-list" style="height: auto;">
            <a onclick="description()" class="mdui-list-item mdui-ripple  mdui-list-item-active" id="description">课程简介</a>
            <a onclick="teacher()" class="mdui-list-item mdui-ripple " id="teacher">教师简介</a>
            <a onclick="precursor()" class="mdui-list-item mdui-ripple " id="precursor">先导课程</a>
            <a onclick="teaching()" class="mdui-list-item mdui-ripple " id="teaching">教学计划</a>
            <a onclick="exams()" class="mdui-list-item mdui-ripple " id="exams">考试方式</a>
            <a onclick="books()" class="mdui-list-item mdui-ripple " id="books">参考书目</a>
            <a class="mdui-list-item mdui-ripple " id="files">课件下载</a>
        </div>
    </div>
</div>


<!-- 信息内容展示 -->

<div class="mdui-card mdui-container">
    <div class=" mdui-row mdui-m-t-2">
        <div id="title" class=" mdui-typo-display-1 mdui-text-center">标题</div>
    </div>
    <div class="mdui-divider-inset mdui-m-y-3"></div>
    <div id="content" class="mdui-typo-headline mdui-row mdui-text-center mdui-m-b-2">内容</div>
</div>

</body>
<script src="../static/js/jquery-3.4.1.min.js"></script>
<script src="../static/js/mdui.min.js"></script>
<script>
    let itemButtons = [$("#description"),$("#teacher"),$("#precursor"),$("#teaching"),$("#exams"),$("#books"),$("#files")]
    // TODO:将富文本放到 页面上

    $.each(itemButtons,function(index, value){
        value.click(function () {
            removeAllHighlight();
            value.addClass("mdui-list-item-active");

            //* 检索
            switch (value.attr("id")) {
                case "description":
                    console.log("描述")
            }
        })


    })

    let contentDiv = $("#content");
    function description() {
        contentDiv.html("${sessionScope.course.description}")
        console.log("简介")
    }

    function teacher() {
        contentDiv.html("${sessionScope.course.teacher}")
    }

    function precursor() {
        contentDiv.html("${sessionScope.course.precursor_Lesson}")
    }

    function teaching() {
        contentDiv.html("${sessionScope.course.teaching_Plans}")
    }

    function exams() {
        contentDiv.html("${sessionScope.course.exams}")
    }

    function books() {
        contentDiv.html("${sessionScope.course.bibliography}")
    }



    function removeAllHighlight(){
        $.each(itemButtons,function(index, value){
            value.removeClass("mdui-list-item-active")
        })
    }
</script>
</html>
