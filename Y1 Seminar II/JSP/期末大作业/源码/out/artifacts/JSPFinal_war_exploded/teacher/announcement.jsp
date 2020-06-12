<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/27
  Time: 13:45
  Made full of love by Sonder Lau
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="utf-8">
    <title>公告预览</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mdui.min.css">
</head>

<body class="mdui-drawer-body-left">

<nav>
<div class="mdui-container-fluid">

    <div class="mdui-row">
        <div class="mdui-typo-headline mdui-center">
            <h4 class="mdui-text-center">${sessionScope.CurrentLesson}</h4>
        </div>
    </div>
    <div class="mdui-row">
        <div class="mdui-typo mdui-col-xs-3 mdui-col-offset-xs-9">
            <h3>欢迎你 : ${sessionScope.teacher.username} <a href="${pageContext.request.contextPath}/logout">登出</a></h3>
        </div>
    </div>

    <div class="mdui-row">
        <div>
            <div class="mdui-bottom-nav mdui-bottom-nav-text-auto mdui-color-black">
                <!-- TODO 跳转链接 -->
                <a href="${pageContext.request.contextPath}/teacher/announcement"
                   class="mdui-ripple mdui-ripple-white mdui-bottom-nav-active">
                    <i class="mdui-icon material-icons">announcement</i>
                    <label>课程公告</label>
                </a>
                <a href="${pageContext.request.contextPath}/teacher/lessoninfo"
                   class="mdui-ripple mdui-ripple-white">
                    <i class="mdui-icon material-icons">class</i>
                    <label>课程信息</label>
                </a>
                <a href="${pageContext.request.contextPath}/teacher/addStudent"
                   class="mdui-ripple mdui-ripple-white">
                    <i class="mdui-icon material-icons">account_circle</i>
                    <label>学生管理</label>
                </a>
                <a href="${pageContext.request.contextPath}/teacher/enterquestion"
                   class="mdui-ripple mdui-ripple-white">
                    <i class="mdui-icon material-icons">archive</i>
                    <label>作业管理</label>
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
            <a onclick="check()" class="mdui-list-item mdui-ripple  mdui-list-item-active " id="check">公告预览</a>
            <a onclick="edit()" class="mdui-list-item mdui-ripple " id="edit">修改公告</a>
        </div>

    </div>

</div>


<div class="mdui-card mdui-container mdui-m-y-5" id="preview">
    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">最新公告</div>
    </div>
    <div class="mdui-divider-inset mdui-m-y-3"></div>
    <div class="mdui-typo-headline mdui-row mdui-text-center mdui-m-b-2" id="announcement">${sessionScope.lesson.announcement}</div>
</div>


<div class="mdui-card mdui-container  mdui-m-y-5" id="add">

    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">修改公告</div>
    </div>

    <div class="mdui-divider-inset mdui-m-y-5"></div>

    <div id="editor" class=" mdui-m-x-3 mdui-m-b-4"></div>

    <div class="mdui-row">
        <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-10 mdui-m-y-3" id="save">保存</button>
    </div>

</div>


</body>

<script src="${pageContext.request.contextPath}/static/js/wangEditor.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/mdui.min.js"></script>
<script>
    let editor;
    $(document).ready(function () {
        $("#add").hide();

        var E = window.wangEditor;
        editor = new E('#editor');
        editor.create();

    })

    let checkButton = $("#check");
    let editButton = $("#edit");

    function check() {
        checkButton.addClass("mdui-list-item-active");
        editButton.removeClass("mdui-list-item-active");

        $("#add").hide();
        $("#preview").show();

    }

    function edit() {
        editButton.addClass("mdui-list-item-active");
        checkButton.removeClass("mdui-list-item-active");

        $("#add").show();
        $("#preview").hide();

        //* 获取现有公告
        editor.txt.html( $("#announcement").html());
        console.log("公告内容 :" +$("#announcement").html());
        <%--$.getJSON({--%>
        <%--    url: "${pageContext.request.contextPath}/feedback",--%>
        <%--    success: function (data) {--%>
        <%--        console.log(data);--%>
        <%--        editor.txt.html(data);--%>
        <%--    }--%>
        <%--})--%>
    }

    $("#save").click(function () {
        console.log(editor.txt.html());
        //* 保存公告内容
        let AnnouncementContent = {
            AnnouncementData : editor.txt.html()
        }
        $.ajax({
            url: "${pageContext.request.contextPath}/teacher/announcement",
            type: "POST",
            data: {
                data: JSON.stringify(AnnouncementContent)
            }
        })

        setTimeout(function(){
            $(location).attr('href','${pageContext.request.contextPath}/teacher/announcement');
        },300)

        <%--setTimeout(function(){--%>
        <%--    $.getJSON({--%>
        <%--        url : "${pageContext.request.contextPath}/feedback",--%>
        <%--        success : function (data) {--%>
        <%--            $("#announcement").html(data);--%>
        <%--            console.log("获取到的新内容: " + data);--%>
        <%--            mdui.snackbar({--%>
        <%--                message: '已更新公告'--%>
        <%--            });--%>
        <%--        }--%>
        <%--    })--%>
        <%--},200)--%>




    })
</script>

</html>
