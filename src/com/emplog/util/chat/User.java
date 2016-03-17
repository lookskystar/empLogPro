package com.emplog.util.chat;

/**
 * ”√ªß
 * 
 * @author lhq
 * 
 */
public class User {

	private String userid;
	
	private String usersessionid;

	private String username;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	

	public String getUsersessionid() {
		return usersessionid;
	}

	public void setUsersessionid(String usersessionid) {
		this.usersessionid = usersessionid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User(String userid,String usersessionid, String username) {
		super();
		this.userid = userid;
		this.usersessionid=usersessionid;
		this.username = username;
	}

}
