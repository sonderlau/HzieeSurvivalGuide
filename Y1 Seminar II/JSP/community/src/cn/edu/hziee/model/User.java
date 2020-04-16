package cn.edu.hziee.model;
 
public class User {
	private Integer id;//关键字id
	private String username;//姓名
	private String password;//密码
	private String checkPassword;//确认密码
	
	public User(String username, String password, String checkPassword) {
		super();
		this.username = username;
		this.password = password;
		this.checkPassword = checkPassword;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
 
}