package net.frog.vo;


import java.util.Date;


public class PostVO {

	protected int index;
	protected String title;
	protected String contents;
	protected String userid;
	protected Date register_date;
	protected Date modify_date;
	protected int visible;
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public void setTitle(String title) {
		this.title = title;
	}
	
	public PostVO(){
		
	}
	
	public PostVO(int _index, String _title,
			String _contents, String _userid, Date _register_date, Date _modify_date, int _visible) {
		index = _index;
		title = _title;
		contents = _contents;
		userid = _userid;
		register_date = _register_date;
		modify_date = _modify_date;
		visible = _visible;
	}
	
	public String getTitle() {
		return title;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int _index) {
		index = _index;
	}
	public String getContent() {
		return contents;
	}
}
