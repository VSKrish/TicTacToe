package models;

public class User {
	String userName;
	Gender gender;
	String email;
	String mobileNum;
	public User(String userName, Gender gender, String email, String mobileNum) {
		super();
		this.userName = userName;
		this.gender = gender;
		this.email = email;
		this.mobileNum = mobileNum;
	}
	public User(String userName) {
		super();
		this.userName = userName;
	}
}
