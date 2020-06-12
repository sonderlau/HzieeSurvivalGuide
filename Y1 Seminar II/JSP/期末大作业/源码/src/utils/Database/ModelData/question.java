package utils.Database.ModelData;

import Model.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class question {

    public static void addQuestionByQuestion(Question question) throws Exception {
        String sql = "insert into question (ID,Type,Brief_Description,Description,Answer,Score,Max_Size,File_Type) values(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = utils.Database.SQLConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,question.getID());
        preparedStatement.setString(2,question.getType());
        preparedStatement.setString(3,question.getBrief_Description());
        preparedStatement.setString(4,question.getDescription());
        preparedStatement.setString(5,question.getAnswer());
        preparedStatement.setFloat(6,question.getScore());
        preparedStatement.setInt(7,question.getMax_Size());
        preparedStatement.setString(8,question.getFile_Type());

        preparedStatement.execute();
    }


    /**
     * @description 若参数有一个为null 则进行无条件的全部查询
     * @param attribute 查询的参数
     * @param value 参数的值
     * @param number 限制数据库每页查询的数量
     * @param page 第几页
     * @return 查询的结果集
     * @throws Exception 数据库查询异常
     */
    public static ArrayList<Question> getQuestionListByAttribute(String attribute,String value, int number, int page) throws Exception {
        String sql = "select * from question where " + attribute + " = "
                + utils.string.StringModification.AddSingleQuotation(value);
        if (attribute == null || value == null){
            sql = "select * from question ";
        }

        sql += " limit " + (page-1)*number + " , " + number;

        System.out.println("Question 限制查询SQL语句为 : " + sql);
        ResultSet resultSet = utils.Database.SQLConnection.getConnection().createStatement().executeQuery(sql);
        ArrayList<Question> questions = new ArrayList<>();
        while (resultSet.next()){
            questions.add(newQuestion(resultSet));
        }

        //? test
        System.out.println("Question 结果数量 " + questions.size() + " 需要的数量为 :　" + number);
        //? ---------------------------------------


        return questions;
    }

    /**
     *
     * @param attribute 属性名
     * @param value 属性值
     * @return 满足条件的结果数量
     * @throws Exception 数据库查询出错
     */
    public static int calculateDataNumber(String attribute,String value) throws Exception {
        String sql = "select * from question where " + attribute + " = "
                + utils.string.StringModification.AddSingleQuotation(value);

        if (attribute == null || value == null){
            sql = "select * from question";
        }

        //* 计算总共有多少条数据的
        int count = 0;



        ResultSet resultSet = utils.Database.SQLConnection.getConnection().createStatement().executeQuery(sql);
        while (resultSet.next()){
            count ++ ;
        }
        return count;

    }


    private static Question newQuestion(ResultSet resultSet) throws SQLException {
        Question question = new Question();

        question.setID(resultSet.getString("ID"));
        question.setType(resultSet.getString("Type"));
        question.setBrief_Description(resultSet.getString("Brief_Description"));
        question.setDescription(resultSet.getString("Description"));
        question.setAnswer(resultSet.getString("answer"));
        question.setScore(resultSet.getFloat("Score"));
        question.setMax_Size(resultSet.getInt("Max_Size"));
        question.setFile_Type(resultSet.getString("File_Type"));

        return question;


    }
}
