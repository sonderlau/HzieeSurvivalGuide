package Control.Teacher;

import Model.Lesson;
import Model.User_Teacher;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import utils.ErrorInfoSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Announcement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //* 获取到新添加的公告信息
        String addLessonAnnouncement = req.getParameter("data");
        System.out.println("新公告内容 " + addLessonAnnouncement);

        IndexServlet.checkSessionTeacherAndLesson(req, resp);

        //todo: 考虑多个公告的功能

        User_Teacher teacher = (User_Teacher) req.getSession().getAttribute("teacher");
        Lesson lesson = (Lesson) req.getSession().getAttribute("lesson");



        if (addLessonAnnouncement != null) {
            //* 更新公告内容的请求
            try {
                JSONObject announcementObject = JSONObject.parseObject(addLessonAnnouncement);
                utils.Database.ModelData.lesson.updateLessonAnnouncementById(lesson.getID(), announcementObject.getString("AnnouncementData"));

                req.getSession().setAttribute("lesson",utils.Database.ModelData.lesson.getLessonInfoById(lesson.getID()));
            } catch (Exception e) {
                e.printStackTrace();
                //! 数据库查询出错
                ErrorInfoSet.ErrorSet(req, resp, "204", "数据库查询出错", "teacher/announcement");
            }
        }

        resp.sendRedirect(req.getContextPath() + "/teacher/announcement.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
