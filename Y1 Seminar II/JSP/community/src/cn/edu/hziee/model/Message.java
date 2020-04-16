package cn.edu.hziee.model;

public class Message {
	private int id;
	private String username;
	private String username_message;
	private int add_time;
	private String manager_message;
	
	public Message(String username, String username_message, int add_time) {
		super();
		this.username = username;
		this.username_message = username_message;
		this.add_time = add_time;
//		this.username_message = username_message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername_message() {
		return username_message;
	}
	public void setUsername_message(String username_message) {
		this.username_message = username_message;
	}

	public int getAdd_time() {
		return add_time;
	}
	public void setAdd_time(int add_time) {
		this.add_time = add_time;
	}
	public String getManager_message() {
		return manager_message;
	}
	public void setManager_message(String manager_message) {
		this.manager_message = manager_message;
	}
	
}
