package net.frog.vo;

import java.sql.Date;

public class ContentVO {
	protected int comment_no;
	protected int board_no;
	protected String comment_content;
	protected String user_id;
	protected Date register_date;
	protected int visible;
	public ContentVO(){}
	public ContentVO(int comment_no,int board_no,String comment_content,
				String user_id,Date register_date,int visible){
		this.comment_no = comment_no;
		this.board_no = board_no;
		this.comment_content = comment_content;
		this.user_id = user_id;
		this.register_date = register_date;
		this.visible = visible;
	}
	
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	
	
	
}