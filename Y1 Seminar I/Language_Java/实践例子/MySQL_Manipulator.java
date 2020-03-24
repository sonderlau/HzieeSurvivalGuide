package finalHomework;


import java.sql.*;

public class mysql {
    static final String URL = "jdbc:mysql://localhost:3306/java";
    static final String ID = "root";
    static final String PASSWORD = "Aes256(MySQL)";

    public static void main(String[] args) throws Exception{

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, ID, PASSWORD);

        if (!con.isClosed()){
            System.out.println("Connected successfully");
        }


        // 增加
        PreparedStatement preAdd;
        String sqlInsert = "insert into role(`id`, `name`) values (99, '!!')";
        preAdd = con.prepareStatement(sqlInsert);
        preAdd.executeUpdate();
        preAdd.close();



        // 删除
        PreparedStatement preDelete;
        String sqlDelete = "delete from role where id=1";
        preDelete = con.prepareStatement(sqlDelete);
        preDelete.executeUpdate();
        preDelete.close();


        // 修改
        String sqlEdit = "update role set id = 666 where id=2";
        PreparedStatement preEdit;
        preEdit = con.prepareStatement(sqlEdit);
        preEdit.executeUpdate();
        preEdit.close();


        // 查找
        String sqlFind = "select id,name from role ";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sqlFind);
        String name = null;
        int id = 0;
        while(rs.next()){
            name = rs.getString("name");
            id = rs.getInt("id");

            System.out.println(id + "\t" + name);

        }

        con.close();


    }
}
