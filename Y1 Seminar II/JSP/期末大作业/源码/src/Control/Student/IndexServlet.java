package Control.Student;

import Model.Lesson;
import Model.User_Student;

import com.alibaba.fastjson.JSONObject;
import utils.Database.ModelData.student;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 禁止缓存 确保数据是即时 更新的
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", -10);


        // 从cookie - 自动登陆的信息 里面获取 code
        String code = null;
        for (Cookie cookie : req.getCookies()) {
            if ("autoLogin".equalsIgnoreCase(cookie.getName())) {
                code = cookie.getValue().split("/")[0];
                System.out.println("自动登陆信息获取到的学号 : " + code);
                req.getSession().setAttribute("code", code);
            }
        }

        //  学号为空的情况
        if (code == null) {

            req.setAttribute("errorMsg", "学号为空 获取失败!");
            req.getRequestDispatcher(req.getContextPath() + "/Error.jsp").forward(req, resp);
        }

        lessonChangeListener(req,resp, code);


        // 跳转到学生主页
        resp.sendRedirect(req.getContextPath() + "/student/index.jsp");


    }


    /**
     *
     * @param req 请求
     * @param resp 响应
     * @param code 学号
     * @throws IOException 错误页面设置时出错
     */
    public static void lessonChangeListener(HttpServletRequest req,HttpServletResponse resp, String code) throws IOException {

        // 获取学生信息对象
        User_Student student = null;
        try {
            student = utils.Database.ModelData.student.getStudentInfoByCode(code);
            req.getSession().setAttribute("name",student.getUsername());
        } catch (Exception e) {
            //! 查询失败
            e.printStackTrace();
            utils.ErrorInfoSet.ErrorSet(req,resp,"Error !","Student_Index : Database Query failed !","student/index");
        }

        //* 改变选课信息
        String LessonCode = req.getParameter("data");
        // 切换课程

        try {

            //* 获取到所有的选课信息 键 : 值
            assert student != null;
            JSONObject Lessons = JSONObject.parseObject(student.getAffiliation()).getJSONObject("Lessons");

            //* 将上面找到的选课信息 放到 Hashmap 便于前端使用
            Map<String, String> choices = new HashMap<>();

            //* 判断是第几个用的
            int count = 0;

            for (Map.Entry<String, Object> entry : Lessons.entrySet()) {


                System.out.println("Key : " + entry.getKey() + "   Value : " + entry.getValue());

                //* 查询到目前的课
                Lesson lessonDataDemo = utils.Database.ModelData.lesson.getLessonInfoById(entry.getKey());

                //! 课程ID ： 课程名

                choices.put(lessonDataDemo.getID(), lessonDataDemo.getName());


                if (LessonCode != null) {
                    //* 进行 针对性的选择
                    req.getSession().setAttribute("course", utils.Database.ModelData.lesson.getLessonInfoById(LessonCode));
                } else {
                    //* 不需要特别的选择某一个课程 选择第一个作为当前课程传过去

                    if (count == 0) {
                        //* 通过session 将 第一个 课程 传给页面
                        req.getSession().setAttribute("course", lessonDataDemo);
                        count++;
                    }
                }

            }

            req.getSession().setAttribute("LessonChoices", choices);

        } catch (Exception e) {
            //! 数据库查询出错
            e.printStackTrace();
            utils.ErrorInfoSet.ErrorSet(req,resp,"402","数据库查询出错","student/index");
        }
    }
}
