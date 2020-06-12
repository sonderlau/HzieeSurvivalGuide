<%--
  Created by IntelliJ IDEA.
  User: SonderLau
  Date: 2020/5/29
  Time: 23:55
  Made full of love by Sonder Lau
--%>


<%--! 只能从Chrome上显示 datetime-local 控件--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <title>布置作业</title>
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
                    <a href="${pageContext.request.contextPath}/teacher/assignments"
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

        <div class="mdui-collapse-item">

            <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
                <i class="mdui-icon material-icons mdui-list-item-icon">add</i>
                <div class="mdui-list-item-content">录入题目</div>
                <i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
            </div>

            <div class="mdui-collapse-item-body mdui-list mdui-list-dense">
                <a class="mdui-list-item mdui-ripple" id="choiceButton">选择题</a>
                <a class="mdui-list-item mdui-ripple" id="blankButton">填空题</a>
                <a class="mdui-list-item mdui-ripple" id="judgementButton">判断题</a>
                <a class="mdui-list-item mdui-ripple" id="uploadButton">文件上传题</a>
            </div>

        </div>

        <div class="mdui-collapse-item mdui-collapse-item-open">

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






<!-- 问题选择 -->

<div class="mdui-card mdui-container mdui-m-y-5" id="questions">

    <div class=" mdui-row mdui-m-t-2">
        <button class=" mdui-btn mdui-btn-raised mdui-col-offset-xs-1 prevStepForQuestionSelection" id="prevStepForQuestionSelection" disabled>
            上一步 [选择作业题目]</button>
        <button class=" mdui-btn mdui-btn-raised mdui-col-offset-xs-7 nextStepForHomeworkAttribute" id="nextStepForHomeworkAttribute">
            下一步 [填写作业属性]</button>
    </div>

    <div class="mdui-divider-inset mdui-m-y-3"></div>

    <div class="mdui-typo-headline mdui-row mdui-p-x-5" id="questionSelection">

        <div class="mdui-row">
            <div class="mdui-textfield mdui-textfield-floating-label mdui-col-xs-3">
                <label class="mdui-textfield-label">每页显示</label>
                <input class="mdui-textfield-input" type="number" value="20" id="numberPerPage" name="questionNumber">
            </div>
        </div>


        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">题目简述包括</label>
            <input class="mdui-textfield-input" type="text" id="briefDescription">
        </div>

        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">题目内容包括</label>
            <input class="mdui-textfield-input" type="text" id="description">
        </div>

        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">题目UUID</label>
            <input class="mdui-textfield-input" type="text" id="id">
        </div>
    </div>
    <div class="mdui-row">
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-11 mdui-m-y-3"
                id="attributeSearch">检索</button>
    </div>

    <table class="mdui-table mdui-table-hoverable mdui-m-b-3">
        <thead>
        <tr>
            <th>题目</th>
            <th>简述</th>
            <th>类型</th>
        </tr>
        </thead>
        <tbody id="questionTableBody">

        </tbody>
    </table>

    <div class="mdui-row">
        <!-- <c:forEach begin="1" end="${sessionScope.numberOfPages}" var="i"> -->
        <!-- <a href="${pageContext.request.contextPath}/teacher/assignments?pageNumber=${i}">第${i}页 <br> -->
        <!-- </c:forEach> -->

    </div>

</div>





<!-- 问题属性 -->

<div class="mdui-card mdui-container  mdui-m-y-5" id="attributes">

    <div class=" mdui-row mdui-m-t-2">
        <button class=" mdui-btn mdui-btn-raised mdui-col-offset-xs-1 prevStepForQuestionSelection" id="prevStepForQuestionSelection">
            上一步 [选择作业题目]</button>
        <button class=" mdui-btn mdui-btn-raised mdui-col-offset-xs-7 nextStepForHomeworkAttribute" id="nextStepForHomeworkAttribute" disabled>
            下一步 [填写作业属性]</button>
    </div>

    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">基本信息</div>
    </div>

    <!-- 作业属性 -->
    <div class="mdui-row">
        <div class="mdui-textfield mdui-col-xs-6 mdui-col-offset-xs-3">
            <i class="mdui-icon material-icons">create</i>
            <input class="mdui-textfield-input" id="brief_description" type="text" placeholder="请填写作业简述">
        </div>

    </div>
    <br>
    <div class="mdui-row">
        <div class="mdui-textfield mdui-col-xs-6 mdui-col-offset-xs-3">
            <i class="mdui-icon material-icons">playlist_add_check</i>
            <textarea class="mdui-textfield-input" id="requirements" placeholder="请填写作业要求"></textarea>
        </div>
    </div>

    <div class="mdui-divider-inset mdui-m-y-5"></div>

    <div class=" mdui-row mdui-m-t-2">
        <div class=" mdui-typo-display-1 mdui-text-center">属性信息</div>
    </div>

    <div class="mdui-row mdui-m-t-4">
        <div class="mdui-col-xs-3 mdui-typo mdui-col-offset-xs-5">
            <h5 class="">将作业布置给</h5>
        </div>
    </div>

    <div class="mdui-row mdui-m-t-4">
        <div class="mdui-col-xs-3 mdui-col-offset-xs-5">

            <select class=" mdui-select" id="classID" required="required" mdui-select>
                <c:forEach var="classInfo" items="${sessionScope.classes}">
                    <option value="${classInfo.ID}">${classInfo.name}</option>
                </c:forEach>
            </select>
        </div>

    </div>

    <br>

    <div class="mdui-row">
        <div class="mdui-textfield  mdui-col-xs-4 mdui-col-offset-xs-4">
            <label class="mdui-textfield-label">开始时间</label>
            <input class="mdui-textfield-input" id="start_time" type="datetime-local" name="start_time"
                   required="required" />
        </div>
    </div>

    <div class="mdui-row">
        <div class="mdui-textfield  mdui-col-xs-4 mdui-col-offset-xs-4">
            <label class="mdui-textfield-label">结束时间</label>
            <input class="mdui-textfield-input" id="end_time" type="datetime-local" name="end_time"
                   required="required" />
        </div>
    </div>

    <div class="mdui-row">
        <div class="mdui-textfield  mdui-col-xs-4 mdui-col-offset-xs-4">
            <label class="mdui-textfield-label">开始时间</label>
            <input class="mdui-textfield-input" type="datetime-local" name="start_time" required="required" />
        </div>
    </div>

    <div class="mdui-row">
        <div class="mdui-col-xs-3  mdui-col-offset-xs-5">
            <label class="  mdui-checkbox mdui-m-t-5">
                <input type="checkbox" id="checkboxOverdueTime" />
                <i class="mdui-checkbox-icon"></i>
                设置补交截止时间
            </label>
        </div>
    </div>

    <div class="mdui-row" id="inputOverdueTime">
        <div class="mdui-textfield  mdui-col-xs-4 mdui-col-offset-xs-4">
            <label class="mdui-textfield-label">补交截止时间</label>
            <input class="mdui-textfield-input" id="overdue_time" type="datetime-local" name="overdue_time"
                   required="required" />
        </div>
    </div>


    <div class="mdui-row">
        <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-col-offset-xs-10 mdui-m-y-3"
                id="saveHomework">保存</button>
    </div>

</div>



</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/mdui.min.js"></script>


<script>
    $(document).ready(function () {
        let attributes = $("#attributes");
        let questions = $("#questions");

        attributes.hide();


        let next = $(".nextStepForHomeworkAttribute");
        let prev = $(".prevStepForQuestionSelection")

        next.click(function () {


            attributes.show();
            questions.hide();
        })

        prev.click(function (){


            attributes.hide();
            questions.show();
        })


    })
</script>

<script>
    $(document).ready(function () {
        $("#inputOverdueTime").hide();

        $("#checkboxOverdueTime").change(function () {

            if ($("#checkboxOverdueTime").prop("checked")) {
                $("#inputOverdueTime").show();

            } else {

                $("#inputOverdueTime").hide();

            }


        })
    })
    // todo: 设置补交时间的按钮
</script>

<script>
    $(document).ready(function () {

        //* 第一次打开进行全部查询
        makeData();

        //* 检索按钮
        $("#attributeSearch").click(() => {
            makeData()
        })



        //* 保存全部作业信息 发送 ajax
        $("#saveHomework").click(function () {

            //* 由问题UUID组成的数组
            let questionList = [];
            let needForReview = 0;
            $("input[name='question']:checked").each(function (index, element) {
                console.log(element)
                questionList.push($(element).val());
                console.log(questionList)
                if ($(element).parent().next().next().text() === '文件上传题') {
                    needForReview = 1;

                }
                console.log(needForReview);
            })


            $.ajax({
                url: "${pageContext.request.contextPath}/teacher/assignments",
                type: "POST",
                data: {
                    "homeworkInfo": JSON.stringify({
                        questionList: questionList,
                        brief_description: $("#brief_description").val(),
                        requirements: $("#requirements").val(),
                        start_time: $("#start_time").val(),
                        end_time: $("#end_time").val(),
                        overdue_time: $("#overdue_time").val(),
                        arrange_for: $("#classID").val(),
                        need_for_review: needForReview
                    })

                }
            })


        })

    })

    //* 查询设置数值放在一起
    function makeData() {
        searchHomework()
        asyncSearchResult()
    }

    // * 获取查询的值 发送ajax 查询符合条件的作业
    function searchHomework() {

        let searchInfo = {
            numberOfDisplayPerPage: $("#numberPerPage").val(),
            brief_description: $("#briefDescription").val(),
            description: $("#description").val()
        }
        console.log("查询信息 :")
        console.log(searchInfo);

        $.ajax({
            url: "${pageContext.request.contextPath}/teacher/assignments",
            type: "POST",
            data: {
                "data": JSON.stringify(searchInfo)
            }
        })
    }

    let consoleData;

    //* 获取后台的查询结果
    function asyncSearchResult() {

        $("#questionTableBody").empty("")

        //* 因为后台 查 传输数据的速度比前端直接获取的速度慢 所以延迟 0.1s 获取结果集
        setTimeout(function () {
            $.getJSON({
                url: "${pageContext.request.contextPath}/feedback",
                success: function (data) {
                    console.log("查询结果")
                    console.log(data)
                    consoleData = data;
                    //* 添加到表格
                    $.each(data, function (index, value) {
                        $("#questionTableBody").append(
                            "<tr>" +
                            "<td>" +
                            "<input type=\"checkbox\" name=\"question\" value=\"" +
                            value.iD + " \"> " + value.iD + "</td>" +
                            "<td>" + value.brief_Description + "</td>" +
                            "<td class='type'>" + typeToString(value.type) + "</td>" +
                            "</tr>"
                        )
                    })
                }
            })
        }, 100)

    }

    function typeToString(type) {
        let typeString;
        switch (type) {
            case "choice":
                typeString = "选择题"
                break;
            case "blank":
                typeString = "填空题"
                break;
            case "file":
                typeString = "文件上传题"
                break;
            case "judgement":
                typeString = "判断题"
                break;
            default:
                typeString = "未知类型题目"
        }
        return typeString
    }
</script>


</html>
