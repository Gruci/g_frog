package net.frog.vo;

import java.util.Date;

public class TestVO {
	
	
	protected int board_no;
	protected String title;
	protected String contents;
	protected String user_id;
	protected Date register_date;
	protected Date modify_date;
	protected int visible;
	
	
	public TestVO(){
		
	}
	public TestVO(int board_no,String title,String contents,String user_id,Date register_date,Date modify_date,int visible){
		this.board_no = board_no;
		this.title = title;
		this.contents = contents;
		this.user_id = user_id;
		this.register_date = register_date;
		this.modify_date =modify_date;
		this.visible = visible;
		
	}
	
	
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}

	

	
	
}
