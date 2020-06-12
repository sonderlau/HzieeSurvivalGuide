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
</head>
<body>

<%--题库管理--%>


<%--作业管理--%>

    <%--评判作业--%>
<%--作业答案--%>
<%--
    判断题 : 0 / 1
    选择题 : AB / BCD
    填空题 : TEXT here
    文件上传题 : file_type : doc/zip/doc
                max_size : 10



--%>

<form action="${pageContext.request.contextPath}/teacher/enterquestion" method="get" >
<%--    在前端请使用不同的分form进行区分 不要让用户进行选择--%>
    <p>题目类型</p>
    <select name="type">
    <option value="choice">选择题</option>
    <option value="judgement">判断题</option>
    <option value="blank">填空题</option>
    <option value="file">文件上传题</option>
    </select>

    <p>题目简述</p><input name="brief_description">
    <p>题目描述</p><input name="description">
<%--   TODO:  前端在答案拼接这里 参考上面的例子--%>
    <p>答案</p><input name="answer">

    <p>分值</p> <input type="number" name="score">
    <p>如果是文件上传题 需要填写如下参数</p>
    文件格式 以/区分<input name="file_type">
    最大文件大小 单位：MB<input name="max_size" type="number">
    <input type="submit" placeholder="提交">
</form>




</body>
</html>
