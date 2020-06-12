package Control.Teacher;

import Model.Homework;
import Model.Lesson;
import Model.Question;
import Model.User_Teacher;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Assignments  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IndexServlet.checkSessionTeacherAndLesson(req,resp);

        //* 获取必要的信息
        User_Teacher teacher = (User_Teacher) req.getSession().getAttribute("teacher");
        Lesson lesson = (Lesson) req.getSession().getAttribute("lesson");



        //* 获取所有的题目
        //* 提供题目的检索

        //* 第几页
            //* 默认第一页
        int pageNumber = 1;
        String pageNumberString = req.getParameter("pageNumber");
            //* 空字符串不做处理
        if (pageNumberString != null) {
            pageNumber = Integer.parseInt(pageNumberString);
        }

        System.out.println("目前是 第 " + pageNumber + "页" );

        //* 查询的信息
        String data = req.getParameter("data");
        System.out.println("查询信息获取 : " + data);
        if (data != null){
            doHomeworkAttributeSearch(req,resp,data,pageNumber);
        }


        try {
            req.getSession().setAttribute("classes", utils.Database.ModelData.classQuery.getAllClassByLessonID(lesson.getID()));
        } catch (Exception e) {
            e.printStackTrace();
            //! 数据 出错
            utils.ErrorInfoSet.ErrorSet(req,resp,"Error !","Teacher_Assignment : Database query failed","teacher/index");
        }

        //* 要添加的作业信息
        String homeworkInfo = req.getParameter("homeworkInfo");


        if (homeworkInfo != null) {

            JSONObject jsonObject = JSONObject.parseObject(homeworkInfo);

            addHomework(jsonObject,lesson.getID());

        }


        req.getRequestDispatcher("/teacher/assignments.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }


    /**
     * @description 将JSON对象中的内容传递到数据库
     * @param jsonObject 解析好的 JSON 对象
     * @param lessonID 当前课程 ID
     * @// TODO: 2020/5/30 提高复用性
     */
    private void addHomework(JSONObject jsonObject,String lessonID) {
        System.out.println("添加的作业信息JSON : " + jsonObject.toJSONString());

        //todo : 添加到数据库

        Homework homework = new Homework();
        homework.setID(UUID.randomUUID().toString());
        homework.setRequirements(jsonObject.getString("requirements"));
        homework.setBrief_Description(jsonObject.getString("brief_description"));
        homework.setStart_Time(jsonObject.getTimestamp("start_time"));
        homework.setEnd_Time(jsonObject.getTimestamp("end_time"));
        homework.setLessonID(lessonID);
        homework.setArrange_For(jsonObject.getString("arrange_for"));

        //* 对JSON 解析 格式化
        JSONObject questionListDemo = new JSONObject();
        JSONArray jsonArray = jsonObject.getJSONArray("questionList");
        questionListDemo.put("QuestionList",jsonArray);
        homework.setQuestion_List(questionListDemo.toJSONString());

        homework.setNeed_For_Review(jsonObject.getIntValue("need_for_review"));

        try {
            utils.Database.ModelData.homework.insertHomeworkByHomework(homework);
        } catch (Exception e) {
            e.printStackTrace();
            //! 数据库插入错误
        }

    }

    /**
     *
     * @param req 请求信息
     * @param data JSON字符串
     * @param pageNumber 第几页
     * @throws IOException 错误页面跳转出错
     * //todo : 提高代码复用性
     */


    private void doHomeworkAttributeSearch(HttpServletRequest req,HttpServletResponse resp,String data,int pageNumber) throws IOException {

        JSONObject searchInfoJSONObject = JSONObject.parseObject(data);


        //* 每页显示数量

        int numberOfDisplaysPerPage = searchInfoJSONObject.getIntValue("numberOfDisplayPerPage");

        String brief_description = searchInfoJSONObject.getString("brief_description");
        String description = searchInfoJSONObject.getString("description");

        try {
            //* 检索参数的值
            if (brief_description.equals("")  && description.equals("") ){
                //* 全部搜索

                //* 总查询条数
                int pageQuantity = utils.Database.ModelData.question.calculateDataNumber(null,null);
                //* 计算总页面数量
                int numberOfPages = pageQuantity % numberOfDisplaysPerPage == 0 ? pageQuantity / numberOfDisplaysPerPage : pageQuantity / numberOfDisplaysPerPage + 1 ;

                req.getSession().setAttribute("numberOfPages",numberOfPages);

                ArrayList<Question> questions = utils.Database.ModelData.question.getQuestionListByAttribute(null,null,numberOfDisplaysPerPage,pageNumber);


                req.getSession().setAttribute("JSONFeedback", JSON.toJSONString(questions));

            }else {
                //* 有参数限制的搜索
                //todo: 两个参数的搜索
                    //! 这里查询总是优先考虑题目内容 即 description的值 暂时不能进行双条件的查询
                //* 总查询条数
                int pageQuantity = utils.Database.ModelData.question.calculateDataNumber(description == null? "brief_description" : "description" ,description == null? brief_description :  description );
                //* 计算总页面数量
                int numberOfPages = pageQuantity % numberOfDisplaysPerPage == 0 ? pageQuantity / numberOfDisplaysPerPage : pageQuantity / numberOfDisplaysPerPage + 1 ;
                req.getSession().setAttribute("numberOfPages",numberOfPages);

                ArrayList<Question> questions = utils.Database.ModelData.question.getQuestionListByAttribute(brief_description == null? "description" : "brief_description",brief_description == null? description : brief_description,numberOfDisplaysPerPage,pageNumber);

                req.getSession().setAttribute("JSONFeedback", JSON.toJSONString(questions));
            }


        } catch (Exception e) {
            e.printStackTrace();
            //! 数据库查询出错
            utils.ErrorInfoSet.ErrorSet(req,resp,"Error !","Teacher_AssignmentManager : Database query failed","teahcer/index");
        }
    }
}
