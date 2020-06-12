package utils.Database.ModelData;

import Model.Class;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class classQuery {
    /**
     *
     * @param lessonID 课程 UUID
     * @return 所有符合条件的班级ArrayList
     * @throws Exception 数据库查询出错
     */
    public static ArrayList<Class> getAllClassByLessonID(String lessonID) throws Exception{
        String sql = "select * from class where Lesson_ID = " + utils.string.StringModification.AddSingleQuotation(lessonID);
        ResultSet resultSet = utils.Database.SQLConnection.getConnection().createStatement().executeQuery(sql);
        ArrayList<Class> classArrayList = new ArrayList<>();

        while (resultSet.next()){
            classArrayList.add(newClass(resultSet));
        }

        return classArrayList;
    }

    private static Class newClass(ResultSet resultSet) throws SQLException {
        Class newClass = new Class();

        newClass.setID(resultSet.getString("ID"));
        newClass.setLesson_ID(resultSet.getString("Lesson_ID"));
        newClass.setName(resultSet.getString("name"));
        newClass.setTeacher(resultSet.getString("teacher"));
        newClass.setCreator(resultSet.getString("creator"));

        return newClass;
    }
}
