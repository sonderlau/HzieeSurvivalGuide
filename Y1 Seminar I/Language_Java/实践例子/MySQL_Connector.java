
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
    static final String URL = "jdbc:mysql://localhost:3306/java";
    static final String ID = "root";
    static final String PASSWORD = "Aes256(MySQL)";

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, ID, PASSWORD);
        if (!con.isClosed()){
            System.out.println("Connected successfully");
        }
        Statement statement = con.createStatement();

        String sql = "select id , name  from role ";

        ResultSet rs = statement.executeQuery(sql);
        String name = null;
        int id = 0;
        while(rs.next()){
            //获取name这列数据
            name = rs.getString("name");
            //获取address这列数据
             id = rs.getInt("id");
            //输出结果
            System.out.println(name + "\t" + id);

        }
        rs.close();
        con.close();


    }
}
