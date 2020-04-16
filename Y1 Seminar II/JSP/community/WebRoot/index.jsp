<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>初心</title>
	<link rel="stylesheet" href="<%=basePath%>/static/css/index.css">
	<script src="<%=basePath%>/static/js/jquery-1.9.0.min.js"></script>
	<script src="<%=basePath%>/static/js/index.js"></script>

  </head>
  
  <body>
    <div id="header">
        <div id="logo">
            <img src="<%=basePath%>/static/image/logo.png"  width="110px" height="90px" alt="">
        </div>

        <div id="nav">
            <ul>
                <li><a href="">首页</a></li>
                <li><a href="add.jsp">物业问题</a></li>
                <li><a href="problem.jsp">快递信息</a></li>
                <li><a href="about.jsp">关于我们</a></li>
            </ul>
        </div>

        <div id="bar">
            <a href="register.jsp" id="register">注册</a>
            <a href="login.jsp" id="login">登录</a>
        </div>
    </div>

    <div id="banner">
        <div class="pic">
            <div class="picImg"><img src="<%=basePath%>/static/image/banner3.jpg" alt=""/></div>
            <div class="picImg"><img src="<%=basePath%>/static/image/banner2.jpg" alt=""/></div>
            <div class="picImg"><img src="<%=basePath%>/static/image/banner4.jpg" alt=""/></div>
            <div class="picImg"><img src="<%=basePath%>/static/image/banner1.jpg" alt=""/></div>
        </div>
        <ul class="tabs">
            <li class="bg"></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>

    <div id="program">
        <h2 class="title">初心，值得托付的物业服务云平台</h2>
        <div>
            <div class="solution left" id="leftLabel">
                <img src="<%=basePath%>/static/image/community.png" alt="">
                <h3 class="title">智慧社区解决方案</h3>
                <p>充分聚焦物业的管理需求及业主的生活场景，拉进物业与业主的距离，建设智慧社区标杆。</p>
                <a href="community_problem.jsp" class="view">了解详情</a>
            </div>

            <div class="solution right" id="rightLabel">
                <img src="<%=basePath%>/static/image/park.png" alt="">
                <h3 class="title">智慧物业解决方案</h3>
                <p>一个平台，链接物业与业主，让物业管理一步到位。打造高效内部管理，提升物业服务形象，集成各种智慧应用，构建和谐人文社区。</p>
                <a href="wuye_problem.jsp" class="view">了解详情</a>
            </div>
        </div>
    </div>

    <div id="business">
        <h2 class="title">初心，主要核心业务模块</h2>
        <div>
            <ul>
                <li>
                    <div class="leftWord"><h3>云收费</h3></div>
                    <div class="leftImg"><img src="<%=basePath%>/static/image/business1.png" alt=""></div>
                </li>
                <li>
                    <h3>云物业</h3>
                    <img src="<%=basePath%>/static/image/business2.png" alt="">
                </li>
                <li>
                    <h3>云客服</h3>
                    <img src="<%=basePath%>/static/image/business3.png" alt="">
                </li>
            </ul>
        </div>
    </div>

    <div id="standard">
        <h2 class="title">物业费标准</h2>
        <div class="list">
            <table>
                <thead>
                    <tr>
                        <th>分类</th>
                        <th>项目</th>
                        <th>收费标准</th>
                        <th>备注</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td rowspan="2">公共物业服务费</td>
                        <td>住宅物业</td>
                        <td>1.56元/m2·月</td>
                        <td rowspan="8">以物价局现批文为准</td>
                    </tr>
                    <tr>
                        <td>商业物业</td>
                        <td>2.00元/m2·月</td>
                    </tr>
                    <tr>
                        <td>水电公共能耗费</td>
                        <td></td>
                        <td>0.15元/m2·月</td>
                    </tr>
                    <tr>
                        <td>电梯使用费</td>
                        <td></td>
                        <td>0.45元/m2·月</td>
                    </tr>
                    <tr>
                        <td rowspan="3">机动车停车费</td>
                        <td>自有车位服务费</td>
                        <td>50.00元/个·月</td>
                    </tr>
                    <tr>
                        <td>地下室车位使用费</td>
                        <td>300.00元/个·月</td>
                    </tr>
                    <tr>
                        <td>计时停放费</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>非机动车停车费</td>
                        <td>地下室车位使用费</td>
                        <td><p>临时停车5.00元/次/小时</p>
                            <p>临时充电10.00元/次/小时</p>
                        </td>
                    </tr>
                    <tr>
                        <td rowspan="3">装修管理相关费用</td>
                        <td>装修垃圾清运费</td>
                        <td>3.50元/m2</td>
                        <td>户外出渣</td>
                    </tr>
                    <tr>
                        <td>建筑垃圾清运费</td>
                        <td>50.00元/m2</td>
                        <td>拆墙建渣，户外出渣</td>
                    </tr>
                    <tr>
                        <td>装修保证金</td>
                        <td>3000.00元/户</td>
                        <td>装修竣工验收3个月后办理退还</td>
                    </tr>
                    <tr>
                        <td colspan="4">注:以实际情况为准，结果仅供参考</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div id="footer">
        <div class="w">
            <dl>
                <dt>
                    <a href="about.jsp">关于我们</a>
                </dt>
                <dd>
                    <a href="about.jsp">关于我们</a>
                </dd>
                <dd>
                    <a href="about.jsp">关于我们</a>
                </dd>
                <dd>
                    <a href="about.jsp">关于我们</a>
                </dd>
            </dl>
            <dl>
                <dt>
                    <a href="problem.jsp">物业问题</a>
                </dt>
                <dd>
                    <a href="problem.jsp">物业问题</a>
                </dd>
                <dd>
                    <a href="problem.jsp">物业问题</a>
                </dd>
                <dd>
                    <a href="problem.jsp">物业问题</a>
                </dd>
            </dl>
            <dl>
                <dt>
                    <a href="problem.jsp">快递信息</a>
                </dt>
                <dd>
                    <a href="problem.jsp">快递信息</a>
                </dd>
                <dd>
                    <a href="problem.jsp">快递信息</a>
                </dd>
                <dd>
                    <a href="problem.jsp">快递信息</a>
            </dl>
            <div class="logo">
                <img src="<%=basePath%>/static/image/logo.png" alt="初心Logo" width="150px" height="150px">
            </div>
        </div>
    </div>
  </body>
</html>
