<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/27
  Time: 23:34
  Made full of love by Sonder Lau
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>学生管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mdui.min.css"/>
</head>

<body class="mdui-drawer-body-left">


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
                   class="mdui-ripple mdui-ripple-white">
                    <i class="mdui-icon material-icons">announcement</i>
                    <label>课程公告</label>
                </a>
                <a href="${pageContext.request.contextPath}/teacher/lessoninfo"
                   class="mdui-ripple mdui-ripple-white">
                    <i class="mdui-icon material-icons">class</i>
                    <label>课程信息</label>
                </a>
                <a href="${pageContext.request.contextPath}/teacher/addStudent"
                   class="mdui-ripple mdui-ripple-white  mdui-bottom-nav-active">
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
            <div class="mdui-list-item-content">学生管理</div>
            <i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
        </div>

        <div class="mdui-collapse-item-body mdui-list" style="height: auto;">
            <a class="mdui-list-item mdui-ripple mdui-list-item-active" id="categoryButton">学生分类</a>
            <a class="mdui-list-item mdui-ripple " id="enterButton">录入学生</a>
        </div>
    </div>
</div>


<div class="mdui-card mdui-container mdui-m-y-5" id="category">
    <div class=" mdui-row mdui-m-x-3 mdui-m-y-4">
        <div class=" mdui-typo-display-1 mdui-text-center">学生分类</div>
    </div>
    <div class="mdui-divider"></div>
    <div class="mdui-typo-headline mdui-table-fluid  mdui-m-y-4">
        <table class="mdui-table mdui-table-hoverable ">
            <thead>
            <tr>
                <th>分类</th>
                <th>我的班级</th>
                <th>删除</th>
                <th>创建人</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>课程名称</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>


            <c:forEach items="${sessionScope.classes}" var="myClass">
            <tr>
                    <td>${myClass.name}</td>
                    <td>
                        <label class="mdui-checkbox">
                        <c:choose>
                            <c:when test="${myClass.teacher == sessionScope.teacher.code}">
                                <input type="checkbox" disabled checked/>
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" disabled />
                            </c:otherwise>
                        </c:choose>
                            <i class="mdui-checkbox-icon"></i>
                        </label>
                    </td>
                    <td><a href="${pageContext.request.contextPath}/teacher/addStudent?del=${myClass.ID}"><i class="mdui-icon material-icons">delete_forever</i></a></td>
                    <td>${myClass.creator}</td>
            </tr>
            </c:forEach>


            </tbody>
        </table>

    </div>
</div>

<div class="mdui-card mdui-container  mdui-m-y-5" id="enter">
    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">录入学生账号</div>
    </div>
    <div class="mdui-divider-inset mdui-m-y-5"></div>
    <div class=" mdui-typo mdui-p-x-5">
        选择班级
        <select id="classID" class="mdui-select" mdui-select="{position: 'bottom'}">
            <c:forEach var="classInfo" items="${sessionScope.classes}">
                <option value="${classInfo.ID}">${classInfo.name}</option>
            </c:forEach>
        </select>

        <!-- todo 检测后 删除掉 div :  mdui-textfield-invalid 类 -->
        <div class="mdui-textfield">
            <i class="mdui-icon material-icons">account_circle</i>
            <label class="mdui-textfield-label">用户名</label>
            <input class="mdui-textfield-input" type="text" id="name"/>
        </div>

        <div class="mdui-textfield  mdui-textfield-floating-label" id="codeDiv">
            <i class="mdui-icon material-icons">confirmation_number</i>
            <label class="mdui-textfield-label">学号</label>
            <input class="mdui-textfield-input" type="number" id="code"/>
            <div class="mdui-textfield-error" id="codeTips">学号重复</div>
        </div>

        <div class="mdui-textfield">
            <i class="mdui-icon material-icons">lock_outline</i>
            <label class="mdui-textfield-label">密码</label>
            <input class="mdui-textfield-input" type="password" id="password"/>
        </div>
        <p id="status"></p>


    </div>
    <div class="mdui-row">
        <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-10 mdui-m-y-3" id="save">保存</button>
    </div>
</div>


</body>

<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/mdui.min.js"></script>

<script>
    $("#save").click(function () {
        let classInfo = {
            classID: $("#classID").val(),
            code: $("#code").val(),
            password: $("#password").val(),
            username: $("#name").val(),
        };

        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/teacher/addStudent",
            data: {
                data: JSON.stringify(classInfo)
            },
        }).done(function () {
            getFeedback();
        });
    });

    // test
    let nice;

    function getFeedback() {
        $.getJSON({
            url: "${pageContext.request.contextPath}/feedback",
            success: function (data) {
                console.log(data);
                nice = data;
                $("#codeTips").html(data.tips);
                //* 检查返回信息 如果不正确则提醒用户

                //* snackbar 提示
                mdui.snackbar({
                    message: data.tips
                });

                //* 根据提示信息 修改class 即样式
                if (data.tips === "已为您成功创建了新学生用户") {
                    $("#codeDiv").removeClass("mdui-textfield-invalid");
                } else {
                    $("#codeDiv").addClass(("mdui-textfield-invalid"));
                }
            },
        });
    }
</script>
<script>
    // 对内容进行控制

    $(document).ready(function () {
        var itemButtons = [$("#enterButton"), $("#categoryButton")];
        var items = [$("#enter"), $("#category")];

        hideAll();
        items[1].show()

        function removeAllActive() {
            $.each(itemButtons, function (index, value) {
                value.removeClass("mdui-list-item-active");
            })
        }

        function hideAll() {
            $.each(items, function (index, value) {
                value.hide();
            })
        }

        $.each(itemButtons, function (index, value) {
            value.click(function () {
                hideAll();
                removeAllActive();

                value.addClass("mdui-list-item-active");

                let valueID = value.attr("id");
                let contentID = valueID.substring(0, valueID.length - 6)


                $("#" + contentID).show();
            })
        })


    })
</script>

</html>