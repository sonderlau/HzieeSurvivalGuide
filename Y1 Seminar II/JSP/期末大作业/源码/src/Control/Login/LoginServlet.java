package Control.Login;

import Model.User_Student;
import Model.User_Teacher;
import utils.Database.ModelData.student;
import utils.Database.ModelData.teacher;
import utils.string.md5String;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        获取到登陆的信息
        String code = req.getParameter("code");
        String password = req.getParameter("password");
        String identity = req.getParameter("identity");

        String codeDemo = null;


        boolean flag = false;



        // 数据库查询 比对密码
        switch (identity) {
            case "t":
                try {
                    User_Teacher teacher_info = teacher.getTeacherInfoByCode(code);
                    if (checkPassword(teacher_info.getPassword(),md5String.crypt(password))){
                        flag = true;
                        System.out.println("老师信息 正确");
                        codeDemo = teacher_info.getCode();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "s":
                try {
                    User_Student student_info = student.getStudentInfoByCode(code);
                    System.out.println("数据库中的密码 : " + student_info.getPassword());
                    System.out.println("输入过来的密码 : " + password);

                    if (checkPassword(student_info.getPassword(),md5String.crypt(password))){
                        flag = true;
                        System.out.println("学生 信息正确");
                        codeDemo = student_info.getCode();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }


        if (flag) {
            // 信息正确
            switch (identity){

                case "t":
                    // 老师
                    addCookie(req, codeDemo + "/" + md5String.crypt(password) + "/t",resp);
                    resp.sendRedirect(req.getContextPath() + "/teacher/index");
                    break;
                case "s":
                    // 学生
                    addCookie(req, codeDemo + "/" + md5String.crypt(password) + "/s",resp);
                    resp.sendRedirect(req.getContextPath() + "/student/index");
                    break;
            }

        }else {
            // 登陆错误
            req.setAttribute("errorMsg","用户名或密码不正确");
            req.getRequestDispatcher("/Error.jsp").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    /**
     *
     * @param req 请求
     * @param value cookie的值
     * @param resp 响应
     */
    private void addCookie(HttpServletRequest req,String value,HttpServletResponse resp){

            Cookie autoLoginCookie = new Cookie("autoLogin",value);
            autoLoginCookie.setPath("/");
            autoLoginCookie.setMaxAge(60*60*24*7);
            resp.addCookie(autoLoginCookie);


    }
    private boolean checkPassword(String p1,String p2) {
        return p1.equalsIgnoreCase(p2);
    }
}
