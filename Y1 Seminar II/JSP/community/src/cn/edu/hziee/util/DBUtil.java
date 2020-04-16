package cn.edu.hziee.util;
 
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
 
public class DBUtil {
	private Connection conn = null;
 
	private ResultSet rs = null;
 
	private PreparedStatement prestmt = null;
 
	public DBUtil() {
		String[] str = readConfigFile();
		try {
			Class.forName(str[0]);
			conn = DriverManager.getConnection(str[1], str[2], str[3]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public static DBUtil getInstance(){
		return new DBUtil();
	}
	public static void main(String[] args) {
		DBUtil dbc = new DBUtil();
		String[] str = dbc.readConfigFile();
		System.out.println(str[0]);
	}
 
	private String[] readConfigFile() {
		String[] str = new String[4];
		try {
			Properties props = new Properties();
			InputStream infile = this.getClass().getResourceAsStream("/ConfigFile/SystemConfig.properties");
			props.load(infile);
 
			str[0] = props.getProperty("driver");
			str[1] = props.getProperty("url");
			str[2] = props.getProperty("username");
			str[3] = props.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
 
	/**
	 * 函数功能：删除数据
	 * 
	 * @param tableName
	 *            表名
	 * @param condition
	 *            条件 例：delete from 表 where condition
	 */
	public boolean deleteData(String tableName, String condition) {
		String sql = "";
		boolean flag = false;
		if (condition == null || condition == "") {
			sql = "delete from " + tableName;
		} else {
			sql = "delete from " + tableName + " where " + condition;
		}
		try {
			prestmt = conn.prepareStatement(sql);
			int rscount = prestmt.executeUpdate();
			if (rscount > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
 
	/**
	 * 函数功能：从表中取出符合条件的数据
	 * 
	 * @param tableName
	 *            表名
	 * @param field
	 *            列名
	 * @param condition
	 *            查询条件
	 * @return 一个向量集合，每个向量含String[] field
	 */
	public Vector<String[]> getData(String tableName, String[] field, String condition) {
		Vector<String[]> vec = new Vector<String[]>();
 
		String strField = "", sql = "";
		for (int i = 0; i < field.length; i++) {
			strField += field[i] + ",";
		}
		strField = strField.substring(0, strField.lastIndexOf(","));
		if (condition == null || condition == "") {
			sql = "select " + strField + " from " + tableName;
		} else {
			sql = "select " + strField + " from " + tableName + " where " + condition;
		}
		try {
			prestmt = conn.prepareStatement(sql);
			rs = prestmt.executeQuery();
			while (rs.next()) {
				String[] temp = new String[field.length];
				for (int i = 0; i < field.length; i++) {
					temp[i] = rs.getString(field[i]);
					// Debug(temp[i]);
				}
				vec.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
		return vec;
 
	}
 
	/**
	 * 函数功能：用户登陆检查
	 * 
	 * @param table
	 * @param condition
	 * @return
	 */
	public boolean CheckedLogin(String table, String condition) {
		boolean flag = false;
		try {
			String sql = "select id from " + table + " where " + condition;
			prestmt = conn.prepareStatement(sql);
			rs = prestmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
 
	/**
	 * 函数功能说明：插入数据
	 * 
	 * @param tableName
	 * @param field
	 * @param value
	 * @throws SQLException
	 *             第二个参数和第三个参数个数要相等，若为空或""，则表示该表全部字段
	 */
	public boolean insertData(String tableName, String[] field, String[] value) {
		boolean flag = false;
		if (field == null || value == null || field.length == 0 || value.length == 0 || field.length != value.length)
			return flag;
		String strField = "", strValue = "";
		for (int i = 0; i < field.length; i++) {
			strField += field[i] + ",";
			strValue += "'" + value[i] + "',";
		}
		strField = strField.substring(0, strField.lastIndexOf(","));
		strValue = strValue.substring(0, strValue.lastIndexOf(","));
		try {
			String sql = "insert into " + tableName;
			sql += " (" + strField + ") values(";
			sql += strValue + ")";
			prestmt = conn.prepareStatement(sql);
			int rscount = prestmt.executeUpdate();
			if (rscount > 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
 
	/**
	 * 函数功能：修改数据
	 * 
	 * @param tableName
	 *            表名
	 * @param field
	 *            字段列表
	 * @param value
	 *            值列表
	 * @param condition
	 *            条件 例：update 表 set 字段1=值1 where 条件
	 */
	public boolean modifyData(String tableName, String[] field, String[] value, String condition) {
		boolean flag = false;
		if (field == null || value == null || field.length == 0 || value.length == 0 || field.length != value.length)
			return flag;
		String str = "";
		for (int i = 0; i < field.length; i++) {
			str += field[i] + "='" + value[i] + "',";
		}
		str = str.substring(0, str.lastIndexOf(","));
		// Debug(str);
		String sql = "";
		if (condition == null || condition == "") {
			sql = "update " + tableName + " set " + str;
		} else {
			sql = "update " + tableName + " set " + str + "  where " + condition;
		}
		// Debug(sql);
 
		try {
			prestmt = conn.prepareStatement(sql);
			int rscount = prestmt.executeUpdate();
			if (rscount > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
 
	/**
	 * 函数功能：执行单条语句返回一个哈希表
	 * 
	 * @param table
	 * @param field
	 * @param condition
	 * @return
	 */
	public Hashtable<String, String> execSQL(String table, String field, String condition) {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		try {
			String sql = "select " + field + " from " + table + " where " + condition;
			System.out.println(sql);
			prestmt = conn.prepareStatement(sql);
			rs = prestmt.executeQuery();
			while (rs.next()) {
				field = field.contains("as") ? field.substring(field.lastIndexOf(' ')+1) : field;
				ht.put(field, rs.getString(field));  //  max(id) as maxid
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ht;
 
	}
}