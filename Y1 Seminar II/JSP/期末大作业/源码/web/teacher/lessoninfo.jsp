<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/27
  Time: 14:46
  Made full of love by Sonder Lau
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>课程信息</title>
    <link rel="stylesheet" href="../static/css/mdui.min.css">
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
                    欢迎你 : ${sessionScope.teacher.username}
                    <a href="${pageContext.request.contextPath}/logout">登出</a>
                </h3>
            </div>
        </div>
        <div class="mdui-row">
            <div>
                <div class="mdui-bottom-nav mdui-bottom-nav-text-auto mdui-color-black">
                    <!-- TODO 跳转链接 -->
                    <a href="${pageContext.request.contextPath}/teacher/announcement" class="mdui-ripple mdui-ripple-white">
                        <i class="mdui-icon material-icons">announcement</i>
                        <label>课程公告</label>
                    </a>
                    <a href="${pageContext.request.contextPath}/teacher/lessoninfo" class="mdui-ripple mdui-ripple-white mdui-bottom-nav-active">
                        <i class="mdui-icon material-icons">class</i>
                        <label>课程信息</label>
                    </a>
                    <a href="${pageContext.request.contextPath}/teacher/addStudent" class="mdui-ripple mdui-ripple-white">
                        <i class="mdui-icon material-icons">account_circle</i>
                        <label>学生管理</label>
                    </a>
                    <a href="${pageContext.request.contextPath}/teacher/enterquestion" class="mdui-ripple mdui-ripple-white">
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
            <a class="mdui-list-item mdui-ripple mdui-list-item-active" id="introButton">课程简介</a>
            <a class="mdui-list-item mdui-ripple " id="teacherButton">教师简介</a>
            <a class="mdui-list-item mdui-ripple " id="precursorButton">先导课程</a>
            <a class="mdui-list-item mdui-ripple " id="teachingButton">教学计划</a>
            <a class="mdui-list-item mdui-ripple " id="examsButton">考试方式</a>
            <a class="mdui-list-item mdui-ripple " id="booksButton">参考书目</a>
            <a class="mdui-list-item mdui-ripple " id="filesButton">课件下载</a>
        </div>
    </div>
</div>


<!-- 信息内容展示 -->

<div class="mdui-card mdui-container mdui-m-y-5" id="intro">
    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">课程简介</div>
    </div>
    <div class="mdui-divider-inset mdui-m-y-3"></div>

    <div id="introEditor" class=" mdui-m-x-3 mdui-m-b-4"></div>

    <div class="mdui-row">
        <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-10 mdui-m-y-3 save" name="description">保存</button>
    </div>

    <input type="hidden" value="${sessionScope.lesson.description}" id="inputDescription">
</div>

<div class="mdui-card mdui-container mdui-m-y-5" id="teacher">
    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">教师简介</div>
    </div>
    <div class="mdui-divider-inset mdui-m-y-3"></div>

    <div id="teacherEditor" class=" mdui-m-x-3 mdui-m-b-4"></div>

    <div class="mdui-row">
        <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-10 mdui-m-y-3 save" name="teacher_description">保存</button>
    </div>

    <input type="hidden" id="inputTeacher" value="${sessionScope.lesson.teacher_Description}">
</div>

<div class="mdui-card mdui-container mdui-m-y-5" id="precursor">
    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">先导课程</div>
    </div>
    <div class="mdui-divider-inset mdui-m-y-3"></div>

    <div id="PrecursorEditor" class=" mdui-m-x-3 mdui-m-b-4"></div>

    <div class="mdui-row">
        <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-10 mdui-m-y-3 save" name="precursor_lesson">保存</button>
    </div>

    <input type="hidden" value="${sessionScope.lesson.precursor_Lesson}" id="inputPrecursor">

</div>

<div class="mdui-card mdui-container mdui-m-y-5" id="teaching">
    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">教学计划</div>
    </div>

    <div class="mdui-divider-inset mdui-m-y-3"></div>

    <div id="TeachingEditor" class=" mdui-m-x-3 mdui-m-b-4"></div>

    <div class="mdui-row">
        <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-10 mdui-m-y-3 save" name="teaching_plans">保存</button>
    </div>

    <input type="hidden" value="${sessionScope.lesson.teaching_Plans}" id="inputTeaching">

</div>

<div class="mdui-card mdui-container mdui-m-y-5" id="exams">
    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">考试方式</div>
    </div>
    <div class="mdui-divider-inset mdui-m-y-3"></div>

    <div id="examsEditor" class=" mdui-m-x-3 mdui-m-b-4"></div>

    <div class="mdui-row">
        <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-10 mdui-m-y-3 save" name="exams">保存</button>
    </div>

    <input type="hidden" value="${sessionScope.lesson.exams}" id="inputExams">
</div>

<div class="mdui-card mdui-container mdui-m-y-5" id="books">
    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">参考书目</div>
    </div>
    <div class="mdui-divider-inset mdui-m-y-3"></div>

    <div id="BooksEditor" class=" mdui-m-x-3 mdui-m-b-4"></div>

    <div class="mdui-row">
        <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-10 mdui-m-y-3 save" name="bibliography">保存</button>
    </div>

    <input type="hidden" value="${sessionScope.lesson.bibliography}" id="inputBooks">
</div>

<div class="mdui-card mdui-container mdui-m-y-5" id="files">
    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">课件下载</div>
    </div>
    <div class="mdui-divider-inset mdui-m-y-3"></div>

    <div id="filesEditor" class=" mdui-m-x-3 mdui-m-b-4"></div>

    <div class="mdui-row">
        <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-10 mdui-m-y-3 save" name="file">保存</button>
    </div>

    <input type="hidden" value="${sessionScope.lesson.file}" id="inputFiles">
</div>




</body>
<script src="${pageContext.request.contextPath}/static/js/wangEditor.min.js"></script>
<script src="../static/js/jquery-3.4.1.min.js"></script>
<script src="../static/js/mdui.min.js"></script>
<script>

    $(document).ready(function () {
//* 编辑器
        //*
        let E = window.wangEditor;

        let introEditor = new E('#introEditor');
        introEditor.create()
        introEditor.txt.html($("#inputDescription").val())

        let teacherEditor = new E("#teacherEditor");
        teacherEditor.create();
        teacherEditor.txt.html($("#inputTeacher").val())

        let precursorEditor = new E("#precursorEditor");
        precursorEditor.create();
        precursorEditor.txt.html($("#inputPrecursor").val())

        let teachingEditor = new E("#teachingEditor");
        teachingEditor.create();
        teachingEditor.txt.html($("#inputTeaching").val());

        let examsEditor = new E("#examsEditor");
        examsEditor.create();
        examsEditor.txt.html($("#inputExams").val());

        let booksEditor = new E("#booksEditor");
        booksEditor.create();
        booksEditor.txt.html($("#inputBooks").val());

        let filesEditor = new E("#filesEditor");
        filesEditor.create();
        filesEditor.txt.html($("#inputFiles").val());


        //* 提交的数据
        let lessonInfo = {
            category : null,
            value : null
        }

        //* 提交按钮
        $(".save").each(function (index, Element) {
            $(Element).click(function () {
                let element = $(this);
                console.log("点击按钮")
                let categoryName = element.attr("name");
                console.log("name : " +  element.attr("name"));
                lessonInfo.category = categoryName;
                lessonInfo.value = getEditorHTML(categoryName);

                //* ajax
                $.ajax({
                    url : "${pageContext.request.contextPath}/teacher/lessoninfo",
                    type : "POST",
                    data : {
                        data : JSON.stringify(lessonInfo)
                    }
                })
            })
        })

        function getEditorHTML(name) {
            switch (name) {
                case "description":
                    return introEditor.txt.html();
                case "teacher_description":
                    return teacherEditor.txt.html();
                case "precursor_lesson":
                    return precursorEditor.txt.html();
                case "teaching_plans":
                    return teachingEditor.txt.html();
                case "exams":
                    return examsEditor.txt.html();
                case "bibliography":
                    return booksEditor.txt.html();
                case "file":
                    return filesEditor.txt.html();
            }
        }

    })

</script>
<script>
    //* 界面切换
    let itemButtons = [$("#introButton"),$("#teacherButton"),$("#teachingButton"),$("#examsButton"),$("#booksButton"),$("#filesButton"),$("#precursorButton")];
    let items = [$("#intro"),$("#teacher"),$("#precursor"),$("#teaching"),$("#exams"),$("#books"),$("#files")];
    $(document).ready(function() {
        $("#intro").hide()

        $.each(items,function(index,value){
            $(value).toggle()
        })

        $.each(itemButtons,function(index,value){
            value.click(function(){
                $.each(itemButtons,function(index,Element){
                    Element.removeClass("mdui-list-item-active")
                })
                $(this).addClass("mdui-list-item-active")

                let buttonID = $(this).attr("id");
                let contentID = buttonID.substring(0, buttonID.length - 6);
                console.log(contentID);

                $.each(items, function(index, value){
                    value.hide();
                })
                $("#"+contentID).show();

            })
        })


    })
</script>
</html>
