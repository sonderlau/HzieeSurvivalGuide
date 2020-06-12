package utils.Database.ModelData;

import Model.Lesson;
import utils.Database.SQLConnection;
import utils.string.StringModification;

import java.sql.ResultSet;
import java.sql.SQLException;

public class lesson {

    public static Lesson getLessonInfoById(String id) throws Exception {
        String sql = "select * from lesson where id = " + StringModification.AddSingleQuotation(id);
        ResultSet resultSet = SQLConnection.getConnection().createStatement().executeQuery(sql);
        resultSet.next();
        return newLesson(resultSet);
    }

    public static Lesson getLessonInfoByName(String name) throws Exception{
        String sql = "select * from lesson where name = " + StringModification.AddSingleQuotation(name);
        ResultSet resultSet = SQLConnection.getConnection().createStatement().executeQuery(sql);
        resultSet.next();
        return newLesson(resultSet);
    }

    public static void updateLessonAnnouncementById(String id,String announcement) throws Exception {
        String sql = " update lesson set announcement = " + StringModification.AddSingleQuotation(announcement)  + " where id = " + StringModification.AddSingleQuotation(id);
        SQLConnection.getConnection().createStatement().executeUpdate(sql);

    }

    public static void updateLessonFileById(String file, String id ) throws Exception{
        String sql = " update lesson set File = " + StringModification.AddSingleQuotation(file) + " where id =" + StringModification.AddSingleQuotation(id);
        SQLConnection.getConnection().createStatement().executeUpdate(sql);

    }

    public static void updateLessonInfoById (String id,String category,String value) throws Exception {
        String sql = "update lesson set " + category + " =  " + StringModification.AddSingleQuotation(value) + " where id = " + StringModification.AddSingleQuotation(id);
        SQLConnection.getConnection().createStatement().executeUpdate(sql);
    }

    public static void deleteLessonById (String id) throws Exception {
        String sql = "delete from lesson where id = " + StringModification.AddSingleQuotation(id);
        SQLConnection.getConnection().createStatement().execute(sql);
    }


    private static Lesson newLesson(ResultSet resultSet) throws SQLException {

        Lesson lesson = new Lesson();

        lesson.setName(resultSet.getString("name"));
        lesson.setTeacher(resultSet.getString("teacher"));
        lesson.setID(resultSet.getString("id"));
        lesson.setDescription(resultSet.getString("description"));
        lesson.setTeacher_Description(resultSet.getString("teacher_description"));
        lesson.setPrecursor_Lesson(resultSet.getString("precursor_lesson"));
        lesson.setTeaching_Plans(resultSet.getString("teaching_plans"));
        lesson.setExams(resultSet.getString("exams"));
        lesson.setBibliography(resultSet.getString("bibliography"));
        lesson.setFile(resultSet.getString("file"));
        lesson.setAnnouncement(resultSet.getString("announcement"));
        lesson.setFile_Type(resultSet.getString("file_type"));

        return lesson;
    }
}
