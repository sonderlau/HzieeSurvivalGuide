package utils.Database.ModelData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.User_Student;
import utils.Database.SQLConnection;
import utils.string.StringModification;

public class student {

    public static User_Student getStudentInfoByCode(String code) throws Exception {

        String sql = "select * from student where code = " + StringModification.AddSingleQuotation(code);
        ResultSet resultSet = SQLConnection.getConnection().createStatement().executeQuery(sql);
        resultSet.next();
        return newStudent(resultSet);

    }

    public static User_Student getStudentInfoByUsername(String username) throws Exception{
        String sql = "select * from student where username = " + StringModification.AddSingleQuotation(username);
        ResultSet resultSet = SQLConnection.getConnection().createStatement().executeQuery(sql);
        resultSet.next();
        return newStudent(resultSet);
    }

    public static void newStudentAccount(User_Student student) throws Exception {
        String sql = "insert into student (code,username,password,affiliation) values(?,?,?,?)";
        PreparedStatement preparedStatement = SQLConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,student.getCode());
        preparedStatement.setString(2,student.getUsername());
        preparedStatement.setString(3,student.getPassword());
        preparedStatement.setString(4,student.getAffiliation());
        preparedStatement.execute();

    }

    public static boolean checkIfCodeExisted(String code) throws Exception {
        String sql = "select * from student where code = " +  StringModification.AddSingleQuotation(code);
        ResultSet resultSet = SQLConnection.getConnection().createStatement().executeQuery(sql);
        return resultSet.next();
    }

    public static void updateStudentAffiliationByCode(String code, String affiliation) throws Exception{
        String sql = "update student set affiliation = " + StringModification.AddSingleQuotation(affiliation) + " where code = " + StringModification.AddSingleQuotation(code);
        SQLConnection.getConnection().createStatement().executeUpdate(sql);

    }


    private static User_Student newStudent(ResultSet resultSet) throws SQLException {
        User_Student student = new User_Student();

        student.setUsername(resultSet.getString("username"));
        student.setPassword(resultSet.getString("password"));
        student.setAffiliation(resultSet.getString("affiliation"));
        student.setCode(resultSet.getString("code"));

        return student;

    }

}
