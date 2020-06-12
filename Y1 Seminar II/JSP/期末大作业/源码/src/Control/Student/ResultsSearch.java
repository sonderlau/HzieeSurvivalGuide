package Control.Student;

import Model.Achievements;
import Model.Homework;
import Model.Lesson;
import Model.User_Student;
import utils.Database.ModelData.achievements;
import utils.Database.ModelData.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// 成绩查询
public class ResultsSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 选课内容的ArrayList
        String affiliationJSON = (String) req.getSession().getAttribute("affiliationJSON");
        // 获取属性信息
        String name =  (String) req.getSession().getAttribute("name");
        String ClassID = (String) req.getSession().getAttribute("class") ;
        String CurrentLesson = (String) req.getSession().getAttribute("CurrentLesson");
        String code = (String) req.getSession().getAttribute("code");


        try {
            // 获取当前课程信息
            Lesson lesson = utils.Database.ModelData.lesson.getLessonInfoByName(CurrentLesson);


            // 所有作业
            ArrayList<Homework> homeworkArrayList = homework.getAllHomeworkByClassIDLessonID(ClassID,lesson.getID());
            ArrayList<Achievements> achievementsArrayList = achievements.getAchievementsArrayListByWholeHomework(homeworkArrayList);

            req.getSession().setAttribute("achievements",achievementsArrayList);
            req.getSession().setAttribute("name",name);
            // 获取学生信息对象
            User_Student student = utils.Database.ModelData.student.getStudentInfoByCode(code);
            req.getSession().setAttribute("name", student.getUsername());


        } catch (Exception e) {
            // TODO 错误处理
            e.printStackTrace();
        }

        //* 学生端通用
    }
}

/**
  * Test Method
  * * Important message
  * ! do not user
  * ? ???
  * TODO:
  * @param: 芜湖
  */
