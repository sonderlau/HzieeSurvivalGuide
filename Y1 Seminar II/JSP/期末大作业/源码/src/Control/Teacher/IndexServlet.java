package Control.Teacher;

import Model.Lesson;
import Model.User_Teacher;
import utils.ErrorInfoSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 禁止缓存 确保数据是即时 更新的
        resp.setHeader("Pragma","No-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires",-10);


        // 登陆成功后会跳转到这里
        // 获取到所需要的信息为其他页面准备
        //* 老师的用户信息 当前课程 / 课程信息

        // 从cookie - 自动登陆的信息 里面获取 code
        String code = null;
        for (Cookie cookie: req.getCookies()){
            if ("autoLogin".equalsIgnoreCase(cookie.getName())){
                code = cookie.getValue().split("/")[0];
                System.out.println("老师主页 获取到的学号 : " + code);
            }
        }



//        checkSessionValidation(req,resp);


        if (code != null) {
            // 有学号
            try {
                //* 老师信息
                User_Teacher teacher = utils.Database.ModelData.teacher.getTeacherInfoByCode(code);
                //* 课程信息
                Lesson lesson = utils.Database.ModelData.lesson.getLessonInfoById(teacher.getInCharge());

                req.getSession().setAttribute("teacher",teacher);
                req.getSession().setAttribute("lesson",lesson);

                // 跳转到 公告预览
                // TODO: 跳转的servlet
                req.getRequestDispatcher("/teacher/announcement").forward(req,resp);

            } catch (Exception e) {
                e.printStackTrace();
                //! 数据库找不到
                utils.ErrorInfoSet.ErrorSet(req,resp,"Error !","Teacher_IndexServlet : Database query failed","teacher/index");
            }
            ;
        }
    }

    /**
     * @param req HttpServletRequest对象
     * @param resp response对象
     * @description 用来判断目前session内是否有所需要的参数
     *              Teacher : 老师对象
     *              Lesson : 当前课程对象
     */
    public static void checkSessionTeacherAndLesson(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User_Teacher teacher = (User_Teacher) req.getSession().getAttribute("teacher");
        Lesson lesson = (Lesson) req.getSession().getAttribute("lesson");

        if (teacher == null || lesson == null) {
            ErrorInfoSet.ErrorSet(req,resp,"204","Teacher Lesson 为空","/teacher/announcement");
        }

    }


}
