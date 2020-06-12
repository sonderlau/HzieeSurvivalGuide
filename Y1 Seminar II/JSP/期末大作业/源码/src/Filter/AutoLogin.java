package Filter;

import Model.User_Student;
import Model.User_Teacher;
import utils.Database.ModelData.student;
import utils.Database.ModelData.teacher;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutoLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();

        String autoLogin = null;

        // cookies不为空
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("autoLogin".equals(cookie.getName())) {
                    autoLogin = cookie.getValue();
                    break;
                }
            }
        }


        if (autoLogin != null) {
            // 有登陆成功过的记录

            String[] loginInfo = autoLogin.split("/");
            String code = loginInfo[0];
            String password = loginInfo[1];
            String identity = loginInfo[2];


            // TODO: 向数据库查询
            boolean flag = false;

            switch (identity) {
                case "t":
                    try {
                        User_Teacher teacher_info = teacher.getTeacherInfoByCode(code);

                        if (checkPassword(teacher_info.getPassword(), password)) {
                            flag = true;
                            System.out.println("老师信息正确");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "s":
                    try {
                        User_Student student_info = student.getStudentInfoByCode(code);

                        if (checkPassword(student_info.getPassword(), password)) {
                            flag = true;
                            System.out.println("学生信息正确");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
            if (flag) {
                // 用户数据正确
                filterChain.doFilter(request, response);

            } else {
                // 数据不正确
                // 大部分情况下是 人为 更改了 cookie信息
                request.setAttribute("errorMsg", "自动登陆失败");
                request.getRequestDispatcher("/Error.jsp")
                        .forward(request, response);
            }


        } else {

            // 没有登陆过的痕迹
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }

    private boolean checkPassword(String p1, String p2) {
        return p1.equalsIgnoreCase(p2);
    }
}
