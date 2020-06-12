package utils.Database;


import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/homeworkmanager?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
    private static final String ID = "root";
    private static final String PASSWORD = "Aes256(MySQL)";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static java.sql.Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,ID,PASSWORD);
    }
}
