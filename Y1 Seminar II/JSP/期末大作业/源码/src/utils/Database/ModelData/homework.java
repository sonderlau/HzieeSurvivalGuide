package utils.Database.ModelData;

import Model.Homework;
import utils.Database.SQLConnection;
import utils.string.StringModification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class homework {

//    public static Homework getHomeworkInfoByID(String id) throws Exception {
//
//        String sql = "select * from lesson where id = " + id;
//        ResultSet resultSet = DatabaseConnectionInformation.connectToDatabase().createStatement().executeQuery(sql);
//        resultSet.next();
//        return newHomework(resultSet);
//
//    }

    public static void insertHomeworkByHomework(Homework homework) throws Exception {
        String sql = "insert into homework(LessonID,ID,Brief_Description,Requirements,Need_For_Review,Arrange_For,Start_Time,End_Time,Overdue_Time,Question_List) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = utils.Database.SQLConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,homework.getLessonID());
        preparedStatement.setString(2,homework.getID());
        preparedStatement.setString(3,homework.getBrief_Description());
        preparedStatement.setString(4,homework.getRequirements());
        preparedStatement.setInt(5,homework.getNeed_For_Review());
        preparedStatement.setString(6,homework.getArrange_For());
        preparedStatement.setTimestamp(7,homework.getStart_Time());
        preparedStatement.setTimestamp(8,homework.getEnd_Time());
        preparedStatement.setTimestamp(9,homework.getOverdue_Time());
        preparedStatement.setString(10,homework.getQuestion_List());

        preparedStatement.execute();



    }


    public static ArrayList<Homework> getAllHomeworkByLessonID(String LessonID) throws Exception {
        String sql = "select * from homework where LessonID = " + StringModification.AddSingleQuotation(LessonID);
        ResultSet resultSet = utils.Database.SQLConnection.getConnection().createStatement().executeQuery(sql);
        ArrayList<Homework> homeworkArrayList = new ArrayList<>();
        while (resultSet.next()){
            homeworkArrayList.add(newHomework(resultSet));
        }

        return homeworkArrayList;

    }


    public static ArrayList<Homework> getAllHomeworkByClassIDLessonID(String ClassID, String LessonID) throws Exception {
        String sql = "select *" +
                "from homework " +
                "where Arrange_For in (" +
                "    select ID" +
                "    from class" +
                "    where ID =" + StringModification.AddSingleQuotation(ClassID) +
                "              and father != '0'" +
                "              and Lesson_ID = " + StringModification.AddSingleQuotation(LessonID) +
                "       or ID in (" +
                "        select father" +
                "        from class" +
                "        where ID = " + StringModification.AddSingleQuotation(ClassID) +
                "    )" +
                ")";

        ResultSet resultSet = SQLConnection.getConnection().createStatement().executeQuery(sql);
        return newHomeworkArrayList(resultSet);



    }

    /**
     * @description 对查询结果集进行整合
     * @param resultSet 查询结果集
     * @return 所有的查询结果
     * @throws SQLException 查询出错
     */
    private static ArrayList<Homework> newHomeworkArrayList(ResultSet resultSet) throws SQLException {


        ArrayList<Homework> homeworkArrayList = new ArrayList<>();

        while (resultSet.next()) {


            Homework homework = new Homework();
            homework = newHomework(resultSet);

            homeworkArrayList.add(homework);
        }

        return homeworkArrayList;

    }

    private static Homework newHomework(ResultSet resultSet) throws SQLException {
        Homework homework = new Homework();
        homework.setID(resultSet.getString("ID"));
        homework.setLessonID(resultSet.getString("LessonID"));
        homework.setBrief_Description(resultSet.getString("Brief_Description"));
        homework.setRequirements(resultSet.getString("Requirements"));
        homework.setNeed_For_Review(resultSet.getInt("Need_For_Review"));
        homework.setArrange_For(resultSet.getString("Arrange_For"));
        homework.setStart_Time(resultSet.getTimestamp("Start_Time"));
        homework.setEnd_Time(resultSet.getTimestamp("End_Time"));
        homework.setOverdue_Time(resultSet.getTimestamp("Overdue_Time"));
        homework.setQuestion_List(resultSet.getString("Question_List"));

        return homework;

    }
}
