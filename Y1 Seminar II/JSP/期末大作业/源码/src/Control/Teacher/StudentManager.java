package Control.Teacher;


import Model.Lesson;
import Model.User_Student;
import Model.User_Teacher;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class StudentManager extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        IndexServlet.checkSessionTeacherAndLesson(req, resp);

        //todo : 自动导入学生功能

        User_Teacher teacher = (User_Teacher) req.getSession().getAttribute("teacher");
        Lesson lesson = (Lesson) req.getSession().getAttribute("lesson");

        System.out.println("当前课程" + lesson.getID() + lesson.getPrecursor_Lesson());


        String data = req.getParameter("data");


        //* 重要参数值 判断
        if (data == null) {
            //* 第一次访问
            //* 输出班级信息 供前端进行选择


            try {
                //* 通过session 传递给前端
                req.getSession().setAttribute("classes", utils.Database.ModelData.classQuery.getAllClassByLessonID(lesson.getID()));

                System.out.print("StudentManager 页面 : 首次访问 ");


            } catch (Exception e) {
                e.printStackTrace();
                //! 数据库查询出错
            }

        } else {
            //* 需要对请求进行处理
            System.out.println("StudentManager 页面 : ！！！ 非首次访问");

            JSONObject jsonObject = JSONObject.parseObject(data);
            System.out.println(jsonObject.toJSONString());
            String classID = jsonObject.getString("classID");
            String code = jsonObject.getString("code");
            String password = jsonObject.getString("password");
            String username = jsonObject.getString("username");

            try {
                String tips = addStudentAccount(code, password, username, lesson.getID(), classID);

                System.out.println(tips);;

                JSONObject jsonFeedBack = new JSONObject();
                jsonFeedBack.put("tips", tips);

                req.getSession().setAttribute("JSONFeedback", jsonFeedBack.toJSONString());

            } catch (Exception e) {
                e.printStackTrace();
                //! 数据库update 出错
                utils.ErrorInfoSet.ErrorSet(req,resp,"Error !","Teacher_StudentManager : Database update failed","teacher/index");
            }
        }

        String delete = req.getParameter("del");
        if (delete != null){
            //* 删除功能
            try {
                utils.Database.ModelData.lesson.deleteLessonById(delete);
            } catch (Exception e) {
                e.printStackTrace();
                //! 删除出错
                utils.ErrorInfoSet.ErrorSet(req,resp,"Error !","Teacher_StudentManager : Database delete failed","teacher/index");
            }
        }

        req.getRequestDispatcher("/teacher/studentmanager.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    /**
     * @param code     学号
     * @param password 密码
     * @param username 用户名
     * @param lessonID 当前课程的 UUID
     * @param classID  当前班级的 UUID
     * @return 检查学号是否存在后的提示信息
     * @description 新建一个学生的账户
     * @// TODO: 2020/5/30 需要增加代码复用性
     */
    private String addStudentAccount(String code, String password, String username, String lessonID, String classID) throws Exception {


        //* 检查此学号的学生是否存在
        User_Student student = new User_Student();

        if (!utils.Database.ModelData.student.checkIfCodeExisted(code)) {
            //* 学号不重复 新建一个用户

            student.setCode(code);
            student.setPassword(utils.string.md5String.crypt(password));
            student.setUsername(username);
            student.setAffiliation("{\n" +
                    "    \"Lessons\": {\n" +
                    "    }\n" +
                    "}");

            //* JSON解析 添加课程
            JSONObject studentAffiliation = JSON.parseObject(student.getAffiliation());
            JSONObject lessons = studentAffiliation.getJSONObject("Lessons");
            lessons.put(lessonID, classID);
            student.setAffiliation(studentAffiliation.toJSONString());

            //* 更新到数据库
            utils.Database.ModelData.student.newStudentAccount(student);

            return "已为您成功创建了新学生用户";
        } else {
            //* 已存在这个账户

            //* 获取已存在的这个学生
            student = utils.Database.ModelData.student.getStudentInfoByCode(code);

            //* JSON解析 添加课程
            JSONObject alreadyStudent = JSON.parseObject(student.getAffiliation());
            JSONObject lessons = alreadyStudent.getJSONObject("Lessons");
            lessons.put(lessonID, classID);

            utils.Database.ModelData.student.updateStudentAffiliationByCode(code, alreadyStudent.toJSONString());

            return "该学生已经存在！已为该学生添加了该课程";
        }


    }

}
