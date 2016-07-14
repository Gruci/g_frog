package net.frog.vo;

import java.util.Date;

public class DinersVO {
/*
 * 

CREATE TABLE diners ( 
  no int not null auto_increment comment '�Ĵ� ��ȣ',
  diner_name varchar(200) not null comment '�Ĵ� �̸�',
  diner_call varchar(200) not null comment '�Ĵ� ��ȭ��ȣ',
  intro text not null comment'�Ĵ� �Ұ�',
����rest_day varchar(200) not null comment '�޹���',
  posting_date datetime not null comment '�ۼ� ��¥',
  PRIMARY KEY(no)
)
COMMENT '�Ĵ�';
 * 
 * 
 */
	
	public DinersVO(){
		
	}
	
	protected int no;
	/*
	 * diner_name;
	 * diner_call
	 * 
	 */
	protected String diner_name;
	protected String diner_call;
	protected String intro;
	protected String rest_day;
	protected Date posting_date;
	protected String diner_directory_name;
	
	public String getDiner_directory_name() {
		return diner_directory_name;
	}
	public void setDiner_directory_name(String diner_directory_name) {
		this.diner_directory_name = diner_directory_name;
	}
	public String getRest_day() {
		return rest_day;
	}
	public void setRest_day(String rest_day) {
		this.rest_day = rest_day;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return diner_name;
	}
	public void setName(String name) {
		this.diner_name = name;
	}
	public String getCall_number() {
		return diner_call;
	}
	public void setCall_number(String call_number) {
		this.diner_call = call_number;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Date getPostring_date() {
		return getPostring_date();
	}
	public void setPostring_date(Date postring_date) {
		this.posting_date = postring_date;
	}

	
	
	   
}
