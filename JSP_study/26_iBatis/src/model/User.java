package model;

import java.util.*;

public class User {
	
	private String userId;
	private String userPw;
	private String userName;
	private Date wdate;
	
	public User(){}

	
	
	public User(String userId, String userPw, String userName, Date wdate) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.wdate = wdate;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	};

	public String toString(){
		
		String result;
		result=String.format("[User: ID=%s. Password=%s, Name=%s, Date=%s]", userId, userPw, userName, wdate);

		return result;
	}

}
