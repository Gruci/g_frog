package net.frog.vo;

import java.util.Date;

public class ReplyVO {
	
	protected int no;
	protected int diners_no;
	protected String user_show_name;
	protected String content;
	protected Date posting_date;
	protected float grade;
	
	public ReplyVO(){
	
	}
	
	public ReplyVO(int no, int diners_no, String user_show_name, String content, Date posting_date, int grade){
		this.no = no;
		this.diners_no = diners_no;
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
	public int getDiners_no() {
		return diners_no;
	}
	public void setDiners_no(int diners_no) {
		this.diners_no = diners_no;
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
	public float getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

}
