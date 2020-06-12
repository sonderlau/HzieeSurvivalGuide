package Control.Teacher;

import Model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class EnterQuestion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IndexServlet.checkSessionTeacherAndLesson(req,resp);
        //* 获取新建的题目
        Question question = getQuestionInfoFromRequest(req);

        if (question != null) {
            //* 对题目进行入库处理
            try {
                utils.Database.ModelData.question.addQuestionByQuestion(question);
            } catch (Exception e) {
                e.printStackTrace();
                //! 数据库insert into 失败
                utils.ErrorInfoSet.ErrorSet(req,resp,"Error !","Teacher_EnterQuestion : Database insert into failed","teacher/index");
            }
        }

        req.getRequestDispatcher("/teacher/enterquestion.jsp").forward(req,resp);

    }

    /**
     *
     * @param req 请求
     * @return 信息组成的 Question对象 如果有异常会返回Null
     */
    private Question getQuestionInfoFromRequest(HttpServletRequest req){
        //* 获取新建的题目
        String brief_description = req.getParameter("brief_description");
        String type = req.getParameter("type");
        String description = req.getParameter("description");

        //* 题目答案
        String answer = req.getParameter("answer");

        if (type == null || description == null || answer == null) {
            //* 关键内容为空
            return null;
        }

        Question question = new Question();

        //* 文件上传题 : 最大文件大小 / 文件上传格式
        if ("file".equals(type)) {
            String file_type = req.getParameter("file_type");
            String max_size = req.getParameter("max_size");

            question.setMax_Size(Integer.parseInt(max_size));
            question.setFile_Type(file_type);
        }

        question.setID(UUID.randomUUID().toString());
        question.setBrief_Description(brief_description);
        question.setDescription(description);
        question.setAnswer(answer);
        question.setType(type);
        question.setScore(Float.parseFloat(req.getParameter("score")));

        return question;



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
