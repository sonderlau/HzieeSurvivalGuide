<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/28
  Time: 22:08
  Made full of love by Sonder Lau
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>作业管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mdui.min.css" />
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
                <h3>
                    欢迎你 : ${sessionScope.teacher.username}
                    <a href="${pageContext.request.contextPath}/logout">登出</a>
                </h3>
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
                       class="mdui-ripple mdui-ripple-white">
                        <i class="mdui-icon material-icons">account_circle</i>
                        <label>学生管理</label>
                    </a>
                    <a href="${pageContext.request.contextPath}/teacher/enterquestion"
                       class="mdui-ripple mdui-ripple-white mdui-bottom-nav-active">
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
    <div class="mdui-list" mdui-collapse="{accordion: true}">


        <div class="mdui-collapse-item mdui-collapse-item-open">

            <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
                <i class="mdui-icon material-icons mdui-list-item-icon">add</i>
                <div class="mdui-list-item-content">录入题目</div>
                <i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
            </div>

            <div class="mdui-collapse-item-body mdui-list" style="height: auto;">
                <a class="mdui-list-item mdui-ripple mdui-list-item-active" id="choiceButton">选择题</a>
                <a class="mdui-list-item mdui-ripple" id="blankButton">填空题</a>
                <a class="mdui-list-item mdui-ripple" id="judgementButton">判断题</a>
                <a class="mdui-list-item mdui-ripple" id="uploadButton">文件上传题</a>
            </div>
        </div>


        <div class="mdui-collapse-item">

            <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
                <i class="mdui-list-item-icon mdui-icon material-icons mdui-text-color-purple">local_mall</i>
                <div class="mdui-list-item-content">作业管理</div>
                <i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
            </div>

            <div class="mdui-collapse-item-body mdui-list">
                <a href="${pageContext.request.contextPath}/teacher/assignments" class="mdui-list-item mdui-ripple">作业概览</a>
                <a href="${pageContext.request.contextPath}/teacher/assignments" class="mdui-list-item mdui-ripple">布置作业</a>
            </div>

        </div>


    </div>
</div>

<!-- 内容输入 -->
<div class="mdui-card mdui-container  mdui-m-y-5" id="enter">
    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">录入题目</div>
    </div>
    <div class="mdui-divider-inset mdui-m-y-5"></div>
    <div class=" mdui-typo mdui-p-x-5">

        <form action="${pageContext.request.contextPath}/teacher/enterquestion" method="post">
            <div class="mdui-textfield mdui-textfield-invalid mdui-textfield-floating-label">
                <i class="mdui-icon material-icons">dehaze</i>
                <label class="mdui-textfield-label">题目简述 (可选)</label>
                <input class="mdui-textfield-input" type="text" name="brief_description" />
            </div>
            <h3>题目描述 请在填写答案的地方插入 <code>&lt;blankSpace&gt;</code></h3>

            <div id="editor" class="mdui-m-y-5"></div>

            <input type="hidden" id="type" value="">


            <div class="mdui-textfield mdui-textfield-floating-label">
                <i class="mdui-icon material-icons">vpn_key</i>
                <label class="mdui-textfield-label">答案</label>
                <input class="mdui-textfield-input" type="password" id="password" name="answer" />
                <div class="mdui-textfield-helper">判断题答案请输入 0 1 答案之间以 <b>/</b>隔开</div>
            </div>

            <div class="mdui-textfield mdui-textfield-floating-label">
                <i class="mdui-icon material-icons">stars</i>
                <label class="mdui-textfield-label">分值</label>
                <input class="mdui-textfield-input" type="number" id="score" name="score" />
            </div>

            <div class="mdui-textfield mdui-textfield-floating-label uploadMark">
                <i class="mdui-icon material-icons">center_focus_weak</i>
                <label class="mdui-textfield-label">文件大小最多不超过</label>
                <input class="mdui-textfield-input" type="number" id="max_size" name="max_size" />
                <div class="mdui-textfield-helper">单位： MB</div>
            </div>


            <label class="mdui-checkbox mdui-m-t-5 uploadMark">
                <input type="checkbox" id="checkboxLimitFileType" />
                <i class="mdui-checkbox-icon"></i>
                限制文件上传格式
            </label>

            <div class="mdui-textfield mdui-textfield-invalid mdui-textfield-floating-label"
                 id="inputLimitFileType">
                <i class="mdui-icon material-icons">report</i>
                <label class="mdui-textfield-label">输入文件限制格式</label>
                <div class="mdui-textfield-helper">只需要输入文件格式 以 <b>/</b>区分</div>
                <input class="mdui-textfield-input" type="text" name="file_type" />
            </div>
            <div class="mdui-row">
                <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-10 mdui-m-y-3" id="save">保存</button>
            </div>
        </form>
    </div>

</div>


</body>

<script src="../static/js/jquery-3.4.1.min.js"></script>
<script src="../static/js/mdui.min.js"></script>
<script>
    $(document).ready(function () {

        $(".uploadMark").hide();
        $("#inputLimitFileType").hide();
        let itemButtons = [$("#choiceButton"), $("#blankButton"), $("#uploadButton"), $("#judgementButton")];

        $.each(itemButtons, function (index, value) {
            value.click(function () {
                let valueId = value.attr("id");
                let contentId = valueId.substring(0, valueId.length - 6);

                $("#type").attr("value",contentId)


                if (contentId === "upload") {
                    $(".uploadMark").show();
                }else{
                    $(".uploadMark").hide();
                }


                $.each(itemButtons,function(index, element){
                    element.removeClass("mdui-list-item-active")
                })
                value.addClass("mdui-list-item-active")

            })

            $("#checkboxLimitFileType").change(function () {

                if ($("#checkboxLimitFileType").prop("checked")) {
                    $("#inputLimitFileType").hide();
                } else {
                    $("#inputLimitFileType").show();
                }

                $("#inputLimitFileType").toggle();
            })
        })

    })
</script>

<script src="${pageContext.request.contextPath}/static/js/wangEditor.min.js"></script>
<script>
    let editor;
    $(document).ready(function () {
        $("#add").hide();

        const E = window.wangEditor;
        editor = new E('#editor');
        editor.create();

    })
</script>

</html>
