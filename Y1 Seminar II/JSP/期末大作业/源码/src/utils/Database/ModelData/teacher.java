package utils.Database.ModelData;

import Model.User_Teacher;
import utils.Database.SQLConnection;
import utils.string.StringModification;

import java.sql.ResultSet;

public class teacher {
    public static User_Teacher getTeacherInfoByCode(String code) throws Exception{

        String sql = "select * from teacher where code = " + StringModification.AddSingleQuotation(code);
        ResultSet resultSet = SQLConnection.getConnection().createStatement().executeQuery(sql);
        resultSet.next();
        return newUserTeacher(resultSet);

    }

    public static User_Teacher getTeacherInfoByUsername(String username) throws Exception{

        String sql = "select * from teacher where username = " + StringModification.AddSingleQuotation(username);
        ResultSet resultSet = SQLConnection.getConnection().createStatement().executeQuery(sql);
        resultSet.next();
        return newUserTeacher(resultSet);
    }

    private static User_Teacher newUserTeacher(ResultSet resultSet) throws Exception{

        User_Teacher teacher = new User_Teacher();

        teacher.setUsername(resultSet.getString("username"));
        teacher.setPassword(resultSet.getString("password"));
        teacher.setInCharge(resultSet.getString("InCharge"));
        teacher.setCode(resultSet.getString("code"));

        return teacher;

    }
}
