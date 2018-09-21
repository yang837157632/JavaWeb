package com.login;

public class UserBean {

	private int userId;
	private String userName;
	private String passwd;
	private String mail;
	private int grade;
	private String myPic;
	
	public void setUserId(int userId){
		
		this.userId=userId;
	}
	
	public String getMyPic() {
		return myPic;
	}

	public void setMyPic(String myPic) {
		this.myPic = myPic;
	}

	public int getUserId(){
		
		return this.userId;	
	}

	
	public void setUserName(String userName) {
		this.userName = userName; 
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd; 
	}

	public void setMail(String mail) {
		this.mail = mail; 
	}

	public void setGrade(int grade) {
		this.grade = grade; 
	}
	public String getUserName() {
		return (this.userName); 
	}

	public String getPasswd() {
		return (this.passwd); 
	}

	public String getMail() {
		return (this.mail); 
	}

	public int getGrade() {
		return (this.grade); 
	}
}
