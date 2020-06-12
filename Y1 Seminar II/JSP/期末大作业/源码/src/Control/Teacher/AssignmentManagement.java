package Control.Teacher;

import Model.Homework;
import Model.Lesson;
import Model.User_Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AssignmentManagement extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IndexServlet.checkSessionTeacherAndLesson(req,resp);

        //* 获取必要的信息
        User_Teacher teacher = (User_Teacher) req.getSession().getAttribute("teacher");
        Lesson lesson = (Lesson) req.getSession().getAttribute("lesson");


        //* 布置过的作业概览
        try {
            ArrayList<Homework> homeworkArrayList = utils.Database.ModelData.homework.getAllHomeworkByLessonID(lesson.getID());
            req.getSession().setAttribute("homeworkArrayList",homeworkArrayList);
        } catch (Exception e) {
            e.printStackTrace();
            //! 查询失败
            utils.ErrorInfoSet.ErrorSet(req,resp,"Error !","Teacher_AssignmentManager : Database query failed","index");
        }


        // TODO: 作业评阅

    }

}
