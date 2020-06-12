package Control.Login;

import Model.User_Student;
import Model.User_Teacher;
import utils.Database.ModelData.student;
import utils.Database.ModelData.teacher;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  code = null ,
                password = null,
                identity= null;

        boolean autoLogin = false;


        if (req.getCookies() != null){
            //* 判断是否有自动登陆信息
            for (Cookie cookie: req.getCookies()){
                if ("autoLogin".equals(cookie.getName())){
                    //* 找到了自动登陆的信息
                    String[] data = cookie.getValue().split("/");
                    //* 覆盖获取到的信息
                    code = data[0];
                    password = data[1];
                    identity = data[2];
                    //* 确认是自动登陆
                    autoLogin = true;
                }
            }
        }



        if (autoLogin) {
            //* 具备自动登陆的信息

            //* 数据库 验证 密码
            boolean flag = false;
            switch (identity) {
                case "t":
                    try {
                        User_Teacher teacher_info = teacher.getTeacherInfoByCode(code);
                        if (checkPassword(teacher_info.getPassword(),password)){
                            flag = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "s":
                    try {
                        User_Student student_info = student.getStudentInfoByCode(code);

                        if (checkPassword(student_info.getPassword(),password)){
                            flag = true;
                            System.out.println("学生 信息正确");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }

            if (flag) {
                //* 信息正确
                switch (identity){

                    case "t":
                        // 老师
                        resp.sendRedirect(req.getContextPath() + "/teacher/index");
                        break;
                    case "s":
                        // 学生
                        resp.sendRedirect(req.getContextPath() + "/student/index");
                        break;
                }

            }else {
                //! 登陆错误
                utils.ErrorInfoSet.ErrorSet(req,resp,"Error !","学号或密码不正确","index");
            }
        }else {

            //! 无自动登陆信息
            resp.sendRedirect(req.getContextPath() + "/login/login.jsp");

        }

    }

    /**
     *
     * @param p1 字符串1
     * @param p2 字符串2
     * @return 忽略大小写的情况下 是否相等
     */
    private boolean checkPassword(String p1,String p2) {
        return p1.equalsIgnoreCase(p2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
