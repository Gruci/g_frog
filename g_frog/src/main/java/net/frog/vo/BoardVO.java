package net.frog.vo;


import java.util.Date;


/**
 * First Editor : kkw
 * Last Editor  :
 * Date         : 2016-07-06
 * Description  :
 * version      :
 */

public class BoardVO {

	protected int no;
	protected String board;
	
	
	protected String userName;
	protected String userEmail;
	protected String password;
	protected Boolean sex;
	protected Date birthDate;
	protected Date createdDate;
	protected Date lastDate;
	protected String imagePath;
	
	public BoardVO(){
		
	}
	
	public BoardVO(String username,String useremail, String password){
		this.userName = username;
		this.userEmail = useremail;
		this.password = password;
	}
	
	public BoardVO(String username,String useremail, String password,Boolean sex,Date birthdate,String imagePath){
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
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String useremail) {
		this.userEmail = useremail;
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
	public void setBirthDate(Date birthdate) {
		this.birthDate = birthdate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createddate) {
		this.createdDate = createddate;
	}
	public Date getlastDate() {
		return lastDate;
	}
	public void setlastDate(Date lastdate) {
		this.lastDate = lastdate;
	}
}
