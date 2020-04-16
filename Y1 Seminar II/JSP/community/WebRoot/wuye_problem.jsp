<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta charset="UTF-8">
    <title>智慧物业解决方案</title>
    <link rel="stylesheet" href="<%=basePath%>/static/css/community_problem.css">
  </head>
  
  <body>
    <div id="header">
        <div id="logo">
            <img src="<%=basePath%>/static/image/logo1.png" width="110px" height="90px" alt="">
        </div>

        <div id="nav">
            <ul>
                <li><a href="index.jsp">首页</a></li>
                <li><a href="problem.jsp">物业问题</a></li>
                <li><a href="information.jsp">快递信息</a></li>
                <li><a href="about.jsp">关于我们</a></li>
            </ul>
        </div>

        <div id="bar">
            <a href="register.jsp" id="register">注册</a>
            <a href="login.jsp" id="login">登录</a>
        </div>
    </div>

	<div id="banner">
	    <h4>智慧物业解决方案</h4>
	    <div class="word">从这里开始，让资产释放价值</div>
	</div>
	
	<div id="info" class="w">
	    <h1 class="title">你的物业，应该是这样的</h1>
	    <p>基于云计算、物联网等先进技术，搭建园区管理支撑和应用服务支撑两大平台，打造管理数字化、办公智能化、生活优质化，大数据应用化的智慧物业平台。</p>
	    <ul>
	        <li>
	            <div class="pic"><img src="<%=basePath%>/static/image/park-1.png" alt=""></div>
	            <div class="word">
	                <h4>物业本身</h4>
	                <p>
	                    通过现代园区管理理念和优质的客户服务，高效招商，数字化资产运营，智能化管理服务树立品牌效应，推动新型战略产业的聚集，带动地区经济发展。
	                </p>
	            </div>
	        </li>
	        <li>
	            <div class="pic"><img src="<%=basePath%>/static/image/park-2.png" alt=""></div>
	            <div class="word">
	                <h4>入驻物业</h4>
	                <p>
	                    为入驻企业提供智能化的办公服务，高质量的物业服务，优质的企业配套服务，包括企业即时通讯，智能财务，智能记账，金融等服务，使企业摆脱信息化建设的负担，实现拎包入驻。
	                </p>
	            </div>
	        </li>
	        <li>
	            <div class="pic"><img src="<%=basePath%>/static/image/park-3.png" alt=""></div>
	            <div class="word">
	                <h4>社区业主</h4>
	                <p>
	                    通过一个APP，实现一站式人员管理，代替员工身份证、工卡、钱包、钥匙，亦能对访客进行全面智能化管理，包括车辆管理、门禁控制、路线指引、物品存放、就餐购物，在线缴费，生活服务等，体验园区的智能高效服务体验。
	                </p>
	            </div>
	        </li>
	    </ul>
	</div>
	<div id="new1">
	    <h1 class="title">从这里开始，让资产释放价值</h1>
	    <div>
	        <img src="<%=basePath%>/static/image/park-4.png" alt="">
	        <h4>高效招商</h4>
	        <p>招商计划，在线招商，客户跟进，品牌落位，全方位解决招商难点，让资产落地更有价值。</p>
	    </div>
	</div>
	<div id="new2">
	    <img src="<%=basePath%>/static/image/park-5.jpg" alt="" style="width: 500px;padding-left: 50px">
	    <h4>优质服务</h4>
	    <p>充分聚焦入驻物业的需求，提供高质服务，智能化物业配套服务，同时为业主提供贴心的生活服务，提高物业入驻粘度。</p>
	</div>
	<div id="new3">
	    <img src="<%=basePath%>/static/image/park-6.png" alt="">
	    <h4>科学管理</h4>
	    <p>资源分析、规范化流程、客户行为分析，全方位数据剖析，驱动决策调整，让物业管理更加科学、高效。</p>
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
                    <a href="information.jsp">快递信息</a>
                </dt>
                <dd>
                    <a href="information.jsp">快递信息</a>
                </dd>
                <dd>
                    <a href="information.jsp">快递信息</a>
                </dd>
                <dd>
                    <a href="information.jsp">快递信息</a>
            </dl>
            <div class="logo">
                <img src="<%=basePath%>/static/image/logo.png" alt="初心Logo" width="150px" height="150px">
            </div>
        </div>
    </div>
  </body>
</html>
