package net.frog.vo;

import java.util.Date;

public class ReplyVO {
	
	protected int no;
	protected int diner_no;
	protected String user_show_name;
	protected String content;
	protected Date posting_date;
	protected int grade;
	
	public ReplyVO(){
	
	}
	
	public ReplyVO(int no, int diner_no, String user_show_name, String content, Date posting_date, int grade){
		this.no = no;
		this.diner_no = diner_no;
		this.user_show_name = user_show_name;
		this.content = content;
		this.posting_date = posting_date;
		this.grade = grade;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getDiner_no() {
		return diner_no;
	}
	public void setDiner_no(int diner_no) {
		this.diner_no = diner_no;
	}
	public String getUser_show_name() {
		return user_show_name;
	}
	public void setUser_show_name(String user_show_name) {
		this.user_show_name = user_show_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(Date posting_date) {
		this.posting_date = posting_date;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

}
