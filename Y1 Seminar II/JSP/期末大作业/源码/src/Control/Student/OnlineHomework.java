package Control.Student;

import Model.Homework;
import Model.Lesson;
import utils.Database.ModelData.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// 在线作业
public class OnlineHomework extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 选课内容的ArrayList
        String affiliationJSON = (String) req.getSession().getAttribute("affiliationJSON");
        // 用户名
        String name =  (String) req.getSession().getAttribute("name");
        String ClassID = (String) req.getSession().getAttribute("class") ;
        String CurrentLesson = (String) req.getSession().getAttribute("CurrentLesson");
        try {
            Lesson lesson = utils.Database.ModelData.lesson.getLessonInfoByName(CurrentLesson);


            // 所有作业
            ArrayList<Homework> homeworkArrayList = homework.getAllHomeworkByClassIDLessonID(ClassID,lesson.getID());




            // TODO: 历史作业问题 2个array list就行了




        } catch (Exception e) {
            // TODO 错误处理
            e.printStackTrace();
        }






    }

//    private static void addSessionAttribute(HttpServletRequest req){
//        req.getSession().setAttribute("announcement", lesson.getAnnouncement());
//        req.getSession().setAttribute("affiliationList",affiliationList);
//        req.getSession().setAttribute("affiliationJSON",affiliationString);
//        req.getSession().setAttribute("CurrentLesson",lesson.getName());
//        req.getSession().setAttribute("code",code);
//        req.getSession().setAttribute("name", student.getUsername());
//        req.getSession().setAttribute("class",ClassID);
//    }


}
