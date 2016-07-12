package net.frog.vo;

import java.util.Date;

public class DinersPhotoVO {
	
	/*

	CREATE TABLE diners_photo_sub_1 (
	  no int not null auto_increment comment '파일 번호',
	  diner_no int not null comment '식당 번호',
	  original_file_name varchar(260) not null comment '파일 본명',
	  stored_file_name varchar(45) not null comment '파일 저장명',
	  posting_date datetime not null comment '업로드 날짜',
	  uploader varchar(45) not null comment '업로더',
	  PRIMARY KEY(no)
	)
	 * 
	 * 
	 */
	protected int no;
	protected int diner_no;
	protected String original_file_name;
	protected String stored_file_name;
	protected Date posting_date;
	protected String uploader;
	
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
	public String getOriginal_file_name() {
		return original_file_name;
	}
	public void setOriginal_file_name(String original_file_name) {
		this.original_file_name = original_file_name;
	}
	public String getStored_file_name() {
		return stored_file_name;
	}
	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}
	public Date getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(Date posting_date) {
		this.posting_date = posting_date;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	
}
