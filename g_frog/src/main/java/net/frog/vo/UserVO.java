package net.frog.vo;


import java.util.Date;


/**
 * First Editor : Daehyun Kim (skeksksk@gmail.com)
 * Last Editor  :
 * Date         : 2016-07-05
 * Description  :
 * version      :
 */

public class UserVO {
	protected int no;
	protected String userName;
	protected String userEmail;
	protected String password;
	protected Boolean sex;
	protected Date birthDate;
	protected Date createdDate;
	protected Date lastDate;
	protected String imagePath;
	
	public UserVO(String username,String useremail, String password,Boolean sex,Date birthdate,String imagePath){
		this.userName = username;
		this.userEmail = useremail;
		this.password = password;
		this.sex = sex;
		this.birthDate = birthdate;
		this.imagePath = imagePath;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getlastDate() {
		return lastDate;
	}
	public void setlastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
}
