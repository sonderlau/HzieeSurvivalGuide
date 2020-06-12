package utils.Database.ModelData;

import Model.Achievements;
import Model.Homework;
import utils.Database.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class achievements {

    /**
     * @description 获取所有的成绩
     * @param homework 当前的作业
     * @return 查找好的成绩
     * @throws Exception 数据库查询有误
     */
    public static ArrayList<Achievements> getAchievementsArrayListByWholeHomework(ArrayList<Homework> homework) throws Exception {
        ArrayList<Achievements> achievements = new ArrayList<>();
        for (Homework hw: homework ){
            String id = hw.getID();
            String sql = "select * from achievements where Homework_ID = " + id;
            ResultSet resultSet = SQLConnection.getConnection().createStatement().executeQuery(sql);
            achievements.add(newAchievements(resultSet));

        }
        return achievements;
    }


    private static Achievements newAchievements(ResultSet resultSet) throws SQLException {
        Achievements achievement = new Achievements();

        achievement.setID(resultSet.getString("ID"));
        achievement.setStudent_ID(resultSet.getString("Student_ID"));
        achievement.setSerial_Number(resultSet.getInt("Serial_Number"));
        achievement.setComment(resultSet.getString("Comment"));
        achievement.setRevised_Score(resultSet.getFloat("Revised_Score"));

        return achievement;
    }


}
