package Control.Teacher;

import Model.Lesson;
import Model.User_Teacher;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LessonInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IndexServlet.checkSessionTeacherAndLesson(req,resp);

        User_Teacher teacher = (User_Teacher) req.getSession().getAttribute("teacher");
        Lesson lesson = (Lesson) req.getSession().getAttribute("lesson");

       //* 发送到前端相关信息
        req.getSession().setAttribute("JSONFeedback",JSON.toJSONString(lesson));


        //* 处理提交过来的更新内容的信息
        String data = req.getParameter("data");
        System.out.println(data);




        if (data != null) {
            //*内容不为空
            try {
                JSONObject lessonInfoJSON = JSONObject.parseObject(data);
                String value = lessonInfoJSON.getString("value");

                String category = lessonInfoJSON.getString("category");
                System.out.println(value);
                System.out.println(category);
                utils.Database.ModelData.lesson.updateLessonInfoById(lesson.getID(),category,value);
            } catch (Exception e) {
                e.printStackTrace();
                //! 数据库更新出错
                utils.ErrorInfoSet.ErrorSet(req,resp,"Error !","Teacher_Lessoninfo : Database update failed","teacher/index");
            }

        }


        resp.sendRedirect(req.getContextPath() + "/teacher/lessoninfo.jsp");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
