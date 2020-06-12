package Control.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LessonInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = (String) req.getSession().getAttribute("code");
        if (code == null) {
            //! 学号找不到
            utils.ErrorInfoSet.ErrorSet(req,resp,"402","学号获取失败","student/index");
        }else {
            IndexServlet.lessonChangeListener(req,resp,code);
            req.getRequestDispatcher("/student/lessoninfo.jsp").forward(req,resp);
        }


//        // 获取 当前课程
//        String lessonName = (String) req.getSession().getAttribute("course");
//
//
//        // 获取不到
//        if (lessonName != null && code != null) {
//            // 获取到课程全部信息
//            try {
//                Lesson lesson = utils.Database.ModelData.lesson.getLessonInfoByName(lessonName);
//                // Java Bean 转换成json
//                String json = JSON.toJSONString(lesson);
//                System.out.println("LessonInfo_JSON :" + json);
//
//
//
//                // 选课列表
//                // 数据库查询 获取学生对象
//                User_Student student = utils.Database.ModelData.student.getStudentInfoByCode(code);
//                // 获取选课信息
//                String affiliation = student.getAffiliation();
//                // 转换成 JSONObject
//                JSONObject jsonObject = JSONObject.parseObject(affiliation);
//                // 获取到 Lessons 对象
//                JSONObject Lessons = jsonObject.getJSONObject("Lessons");
//                // 将选课内容从json解析成 对象的形式
//                ArrayList<String> affiliationList = new ArrayList<>();
//                for (Map.Entry<String,Object> entry : Lessons.entrySet()){
//                    affiliationList.add((String) entry.getKey());
//                }
//
//                // 传输数据
//                    // 课程所有的信息
//                req.getSession().setAttribute("lessonInfo",json);
//                    // 选课的ArrayList
//                req.getSession().setAttribute("affiliationList",affiliationList);
//                    // 选课内容的JSON
//                req.getSession().setAttribute("affiliationJSON",affiliation);
//                    // 用户名
//                req.getSession().setAttribute("name", utils.Database.ModelData.student.getStudentInfoByCode(code).getUsername());
//                    // 学号
//                req.getSession().setAttribute("code",code);
//
//                // 跳转到页面
//                resp.sendRedirect(req.getContextPath() + "/student/lessoninfo.jsp");
//            } catch (Exception e) {
//                e.printStackTrace();
//                req.setAttribute("errorMsg","数据库查询失败  --- from Student_LessonInfo");
//                req.getRequestDispatcher(req.getContextPath() + "/Error.jsp").forward(req,resp);
//            }
//        }else {
//            // 此时获取不到参数
//            req.setAttribute("errorMsg","信息为空 --- from Student_LessonInfo");
//            req.getRequestDispatcher(req.getContextPath() + "/Error.jsp").forward(req,resp);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
