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
    <title>智慧社区解决方案</title>
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
        <h4>智慧社区解决方案</h4>
        <div class="word">为物业赋能，让社区生活更美好</div>
    </div>

    <div id="info" class="w">
        <h1 class="title">初心社区解决方案</h1>
        <p>初心智慧社区解决方案，将服务创新作为产品创新的理念，是真正的移动互联网时代物业服务平台，为物业企业与业主提供云收费、云租赁、云客服、云物业、品质管理、智能巡更、云社商、移动验房等全方位云服务，充分聚焦物业企业的管理痛点和使用场景，通过一体化云解决方案为物业赋能，提高物业运营管理效率和服务品质，让社区生活更美好。</p>
        <ul>
            <li>
                <div class="pic"><img src="<%=basePath%>/static/image/wuyeqiye.png" alt=""></div>
                <div class="word">
                    <h4>物业企业</h4>
                    <p>
                        整合强大的云生态，帮助物业打造财务、业务、移动办公的物业一体化云解决方案，提升物业服务企业服务效率，降低运营成本。
                    </p>
                </div>
            </li>
            <li>
                <div class="pic"><img src="<%=basePath%>/static/image/wuyeguanjia.png" alt=""></div>
                <div class="word">
                    <h4>物业管家</h4>
                    <p>
                        物业管家可使用管家助手APP，实现客服、巡检、品质、巡更、工单等全移动化的服务，为业主提供最贴心的服务，轻松完成各项工作。
                    </p>
                </div>
            </li>
            <li>
                <div class="pic"><img src="<%=basePath%>/static/image/shequyezhu.png" alt=""></div>
                <div class="word">
                    <h4>社区业主</h4>
                    <p>
                        通过初心APP及服务公众号，为业主提供门禁、停车、缴费、生活服务、社圈等各项服务，为业主提供更便捷的一站式服务新体验，一机在手，服务无忧。
                    </p>
                </div>
            </li>
        </ul>
    </div>
    <div id="new1">
        <h1 class="title">从这里开始，让社区生活更美好</h1>
        <div>
            <img src="<%=basePath%>/static/image/new1.png" alt="">
            <h4>新平台</h4>
            <p>在线租赁模式，免硬件网络设备、免专业IT人员，系统上线快，极大地降低物业向数字化转型的投入。</p>
        </div>
    </div>
    <div id="new2">
        <img src="<%=basePath%>/static/image/new2.png" alt="">
        <h4>新服务</h4>
        <p>以业主为中心，业主通过微信公众号或APP连接物业智能生活。数字化社区生活环境，提升业主的幸福生活指数。</p>
    </div>
    <div id="new3">
        <img src="<%=basePath%>/static/image/new3.png" alt="">
        <h4>新生态</h4>
        <p>整合线上线下资源，进行商业模式创新，通过社区增值服务不断为企业创造新的盈利点，获取高额增值回报。</p>
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
